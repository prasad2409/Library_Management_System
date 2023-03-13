package com.Project.Librarymanagementsystem.Service;

import com.Project.Librarymanagementsystem.Entity.LibraryCard;
import com.Project.Librarymanagementsystem.Entity.Student;
import com.Project.Librarymanagementsystem.Enum.Status;
import com.Project.Librarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student){
        LibraryCard card = new LibraryCard();
        card.setStatus(Status.ACTIVATED);
        card.setValidTill("03/2025");
        card.setStudent(student);

        student.setCard(card);

        studentRepository.save(student);
    }
    public void deleteStudent(int id){
        studentRepository.deleteById(id);
    }
}
