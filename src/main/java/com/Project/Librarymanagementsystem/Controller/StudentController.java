package com.Project.Librarymanagementsystem.Controller;

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
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "Student added successfully";
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
        return "Student deleted";
    }
}
