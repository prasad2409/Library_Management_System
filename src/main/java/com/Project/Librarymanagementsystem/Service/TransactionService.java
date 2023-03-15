package com.Project.Librarymanagementsystem.Service;

import com.Project.Librarymanagementsystem.DTO.IssueBookRequestDto;
import com.Project.Librarymanagementsystem.DTO.IssueBookResponseDto;
import com.Project.Librarymanagementsystem.Entity.Book;
import com.Project.Librarymanagementsystem.Entity.LibraryCard;
import com.Project.Librarymanagementsystem.Entity.Transaction;
import com.Project.Librarymanagementsystem.Enum.Status;
import com.Project.Librarymanagementsystem.Enum.TransactionStatus;
import com.Project.Librarymanagementsystem.Repository.BookRepository;
import com.Project.Librarymanagementsystem.Repository.LibraryCardRepository;
import com.Project.Librarymanagementsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    LibraryCardRepository libraryCardRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {
        Transaction transaction = new Transaction();
        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        LibraryCard card;
        try{
            card =libraryCardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Card Id is Invalid");
            transactionRepository.save(transaction);
            throw new Exception("Invalid card Id");
        }
        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Invalid Book Id");
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book Id");
        }
        transaction.setBook(book);
        transaction.setCard(card);

        if(card.getStatus()!= Status.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Your card is not activated");
            transactionRepository.save(transaction);
            throw new Exception("Card is Not Activated");
        }
        if(book.isIssued()){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transaction.setMessage("Book is already Issued");
            transactionRepository.save(transaction);
            throw new Exception("Book is already Issued");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setMessage("Transaction Successful");

        book.setIssued(true);
        book.setCard(card);
        book.getTransactions().add(transaction);
        card.getTransactions().add(transaction);
        card.getBooks().add(book);

        libraryCardRepository.save(card);

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setTransactionStatus(TransactionStatus.SUCCESS);
        issueBookResponseDto.setTransactionId(transaction.getTransactionNumber());
        issueBookResponseDto.setBookName(book.getTitle());

        return issueBookResponseDto;
    }
}
