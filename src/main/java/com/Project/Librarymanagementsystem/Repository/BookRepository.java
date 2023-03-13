package com.Project.Librarymanagementsystem.Repository;

import com.Project.Librarymanagementsystem.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BookRepository extends JpaRepository<Book,Integer> {
}
