package com.example.student.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
@Data
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long studentId;
    private String name;
    private String emailId;
    private LocalDate dateOfBirth;
    @Transient
    private int age;

    public Student(long studentId, String name, String emailId, LocalDate dateOfBirth) {
        this.studentId = studentId;
        this.name = name;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String name, String emailId, LocalDate dateOfBirth) {
        this.name = name;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}
