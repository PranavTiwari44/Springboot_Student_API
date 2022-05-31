package com.example.demo.student;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    @Transient
    private Integer age;
    private LocalDate dub;
    private String email;

    public student() {
    }

    public student(Long id, String name, LocalDate dub, String email) {
        this.id = id;
        this.name = name;
        this.dub = dub;
        this.email = email;
    }

    public student(String name, LocalDate dub, String email) {
        this.name = name;
        this.dub = dub;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Period.between(dub, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDub() {
        return dub;
    }

    public void setDub(LocalDate dub) {
        this.dub = dub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dub=" + dub +
                ", email='" + email + '\'' +
                '}';
    }
}
