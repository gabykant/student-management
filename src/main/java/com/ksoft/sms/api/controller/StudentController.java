package com.ksoft.sms.api.controller;

import com.ksoft.sms.api.models.Student;
import com.ksoft.sms.api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public String registerStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
        return "New student added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Student>> getStudentById(@PathVariable("id")  int id ) {
        Optional<Student> foundElement = studentService.getStudentById(id);
        if(foundElement.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundElement);
        }
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.all();
        return ResponseEntity.ok(students);
    }
}
