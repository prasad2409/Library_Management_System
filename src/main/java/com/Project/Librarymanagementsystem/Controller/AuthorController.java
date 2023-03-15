package com.Project.Librarymanagementsystem.Controller;

import com.Project.Librarymanagementsystem.DTO.AuthorRequestDto;
import com.Project.Librarymanagementsystem.DTO.AuthorResponseDto;
import com.Project.Librarymanagementsystem.Entity.Author;
import com.Project.Librarymanagementsystem.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public AuthorResponseDto addAuthor(@RequestBody AuthorRequestDto authorRequestDto){
        return authorService.addAuthor(authorRequestDto);
    }
}
