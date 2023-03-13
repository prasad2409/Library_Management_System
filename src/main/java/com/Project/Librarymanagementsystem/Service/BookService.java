package com.Project.Librarymanagementsystem.Service;

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
    public String addBook(Book book){
        Author author;
        try{
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e){
            return "Book Not Added";
        }
        List<Book> booksWritten = author.getBooks();
        booksWritten.add(book);
        authorRepository.save(author);
        return "Book Added";
    }
}
