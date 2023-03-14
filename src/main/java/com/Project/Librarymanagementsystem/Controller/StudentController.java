package com.Project.Librarymanagementsystem.Controller;

import com.Project.Librarymanagementsystem.DTO.StudentRequestDto;
import com.Project.Librarymanagementsystem.DTO.StudentResponseDto;
import com.Project.Librarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.Project.Librarymanagementsystem.Entity.Student;
import com.Project.Librarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){
        studentService.addStudent(studentRequestDto);
        return "Student added successfully";
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
        return "Student deleted";
    }
    @PutMapping("/update_email")
    public StudentResponseDto updateStudentEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }
}
