package com.Project.Librarymanagementsystem.Controller;

import com.Project.Librarymanagementsystem.DTO.BookRequestDto;
import com.Project.Librarymanagementsystem.DTO.BookResponseDto;
import com.Project.Librarymanagementsystem.Entity.Book;
import com.Project.Librarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.addBook(bookRequestDto);
    }
}
