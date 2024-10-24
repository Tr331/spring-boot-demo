package com.example.student.service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> existingStudent = studentRepository.findStudentByEmailId(student.getEmailId());

        if (existingStudent.isPresent()) {
            throw new IllegalStateException("Email already exists");
        }

        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if (!exists) {
            throw new IllegalStateException("Student with id "+studentId+" does not exist!");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String emailId) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(()-> new IllegalStateException(
                        "Student with id "+studentId+" does not exist!"
                ));

        if (name != null && !name.isEmpty() && !Objects.equals(student.getName(),name)){
            student.setName(name);
        }

        if (emailId != null && !emailId.isEmpty() && !Objects.equals(student.getEmailId(),emailId)){
            Optional<Student> studentOptional = studentRepository.findStudentByEmailId(emailId);
            if (studentOptional.isPresent()){
                throw new RuntimeException("email is taken!");
            }
            student.setEmailId(emailId);
        }
    }
}
