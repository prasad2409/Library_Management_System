package com.Project.Librarymanagementsystem.Entity;

import com.Project.Librarymanagementsystem.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int price;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @ManyToOne
    @JoinColumn
    Author author;
}
