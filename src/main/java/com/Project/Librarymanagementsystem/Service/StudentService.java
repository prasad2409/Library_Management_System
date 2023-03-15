package com.Project.Librarymanagementsystem.Service;

import com.Project.Librarymanagementsystem.DTO.StudentRequestDto;
import com.Project.Librarymanagementsystem.DTO.StudentResponseDto;
import com.Project.Librarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.Project.Librarymanagementsystem.Entity.LibraryCard;
import com.Project.Librarymanagementsystem.Entity.Student;
import com.Project.Librarymanagementsystem.Enum.Status;
import com.Project.Librarymanagementsystem.Repository.StudentRepository;
import com.Project.Librarymanagementsystem.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto){
        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setEmail(studentRequestDto.getEmail());

        LibraryCard card = new LibraryCard();
        card.setStatus(Status.ACTIVATED);
        card.setStudent(student);
        card.setValidTill(studentRequestDto.getValidTill());
        student.setCard(card);

        Student newStudent =studentRepository.save(student);

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setEmail(newStudent.getEmail());
        studentResponseDto.setName(newStudent.getName());
        studentResponseDto.setId(newStudent.getId());

        return studentResponseDto;

    }
    public void deleteStudent(int id)  {
        studentRepository.deleteById(id);
    }
    public StudentResponseDto updateEmail(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

        Student updateStudent = studentRepository.save(student);

        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updateStudent.getId());
        studentResponseDto.setName(updateStudent.getName());
        studentResponseDto.setEmail(updateStudent.getEmail());

        return studentResponseDto;
    }
}
