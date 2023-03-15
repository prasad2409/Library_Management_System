package com.Project.Librarymanagementsystem.Service;

import com.Project.Librarymanagementsystem.DTO.AuthorRequestDto;
import com.Project.Librarymanagementsystem.DTO.AuthorResponseDto;
import com.Project.Librarymanagementsystem.Entity.Author;
import com.Project.Librarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto){
        Author author = new Author();
        author.setEmail(authorRequestDto.getEmail());
        author.setAge(authorRequestDto.getAge());
        author.setName(authorRequestDto.getName());
        author.setMobNo(authorRequestDto.getMobNo());

        Author newAuthor = authorRepository.save(author);

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setMobNo(newAuthor.getMobNo());
        authorResponseDto.setName(newAuthor.getName());

        return authorResponseDto;
    }

}
