package com.Project.Librarymanagementsystem.Service;

import com.Project.Librarymanagementsystem.Entity.Author;
import com.Project.Librarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public void addAuthor(Author author){
        authorRepository.save(author);
    }

}
