package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class studentService {

    private final studentRepository student_Repository;

    @Autowired
    public studentService(studentRepository student_Repository) {
        this.student_Repository = student_Repository;
    }

    public void addNewStudent(student std) throws IllegalAccessException {
        Optional<student> studentOptional = student_Repository.findStudentByEmail(std.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalAccessException("Email Taken!");
        }
        student_Repository.save(std);
    }

    public List<student> getStudents() {
        return student_Repository.findAll();
    }

    public void deleteStudent(Long studentId) throws IllegalAccessException {
        boolean exists = student_Repository.existsById(studentId);
        if (!exists) {
            throw new IllegalAccessException("Student with student id: " + studentId + " does not exist!");
        }
        student_Repository.deleteById(studentId);
    }

    @Transactional
    public void updateStudents(Long studentId, String name, String email) throws IllegalAccessException {
        student std = student_Repository.findById(studentId).orElseThrow(() -> new IllegalArgumentException(
                "student with id: " + studentId + " does not exist!"
        ));


        if (name != null &&
        name.length() > 0 && !Objects.equals(std.getName(), name)){
            std.setName(name);
        }

        if (email != null &&
                email.length() > 0 && !Objects.equals(std.getEmail(), email)){
            Optional<student> studentOptional = student_Repository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalAccessException("email taken");
            }
            std.setEmail(email);
        }

    }
}
