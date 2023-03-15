package com.Project.Librarymanagementsystem.Service;

import com.Project.Librarymanagementsystem.DTO.BookRequestDto;
import com.Project.Librarymanagementsystem.DTO.BookResponseDto;
import com.Project.Librarymanagementsystem.Entity.Author;
import com.Project.Librarymanagementsystem.Entity.Book;
import com.Project.Librarymanagementsystem.Repository.AuthorRepository;
import com.Project.Librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;
    public BookResponseDto addBook(BookRequestDto bookRequestDto){
       Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();
       Book book = new Book();
       book.setTitle(bookRequestDto.getTitle());
       book.setGenre(bookRequestDto.getGenre());
       book.setPrice(bookRequestDto.getPrice());
       book.setIssued(false);
       book.setAuthor(author);


       author.getBooks().add(book);
       authorRepository.save(author);

       BookResponseDto bookResponseDto = new BookResponseDto();
       bookResponseDto.setTitle(book.getTitle());
       bookResponseDto.setPrice(book.getPrice());

       return bookResponseDto;
    }
}
