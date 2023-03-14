package com.Project.Librarymanagementsystem.Entity;

import com.Project.Librarymanagementsystem.Enum.Status;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;
    @Enumerated(EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date updationDate;
    @OneToOne
    @JoinColumn
    Student student;

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

    @OneToMany(mappedBy = "card",cascade = CascadeType.ALL)
    List<Book> books = new ArrayList<>();
}
