package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;


@RestController
@RequestMapping(path = "api/v1/student")
public class studentController {

    private final studentService student_Service;

    @Autowired
    public studentController(studentService student_Service) {
        this.student_Service = student_Service;
    }

    @GetMapping
    public List<student> getStudents(){
        return student_Service.getStudents();

    }

    @PostMapping
    public void registerNewStudent(@RequestBody student std) throws IllegalAccessException {
        student_Service.addNewStudent(std);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) throws IllegalAccessException {
        student_Service.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStatement(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) throws IllegalAccessException {
        student_Service.updateStudents(studentId, name, email);
    }
}
