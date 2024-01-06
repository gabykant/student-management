package com.ksoft.sms.api.service;

import com.ksoft.sms.api.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    Student saveStudent(Student student);
    Optional<Student> getStudentById(int id);
    List<Student> all();
}
