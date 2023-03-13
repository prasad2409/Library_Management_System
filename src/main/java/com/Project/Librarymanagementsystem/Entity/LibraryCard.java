package com.Project.Librarymanagementsystem.Entity;

import com.Project.Librarymanagementsystem.Enum.Status;
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
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;
    private String validTill;
    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    @JoinColumn
    Student student;
}
