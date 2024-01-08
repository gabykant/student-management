package com.ksoft.sms.api.service;

import com.ksoft.sms.api.models.Student;
import com.ksoft.sms.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImplementation implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(int id) {
        return  studentRepository.findById(id);
    }

    @Override
    public List<Student> all() {
        return studentRepository.findAll();
    }

    @Override
    public boolean updateStudent(Student student) {
        Optional<Student> st = studentRepository.findById(student.getId());
        if(st.isPresent()) {
            Student record = st.get();
            record.setFirstname(student.getFirstname());
            record.setLastname(student.getLastname());
            record.setAddress(student.getAddress());
            record.setDob(student.getDob()); 
            studentRepository.save(record); 
            return true;
        } 
        return false;
    }


}
