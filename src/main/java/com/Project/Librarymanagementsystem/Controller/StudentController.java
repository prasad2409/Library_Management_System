package com.Project.Librarymanagementsystem.Controller;

import com.Project.Librarymanagementsystem.DTO.StudentRequestDto;
import com.Project.Librarymanagementsystem.DTO.StudentResponseDto;
import com.Project.Librarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.Project.Librarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public StudentResponseDto addStudent(@RequestBody StudentRequestDto studentRequestDto){
        return studentService.addStudent(studentRequestDto);
    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id ) throws Exception {
        try{
            studentService.deleteStudent(id);
        }
        catch (Exception e) {
            return "StudentId is Invalid";
        }
        return "Student Deleted";
    }
    @PutMapping("/update_email")
    public StudentResponseDto updateStudentEmail(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto){
        return studentService.updateEmail(studentUpdateEmailRequestDto);
    }
}
