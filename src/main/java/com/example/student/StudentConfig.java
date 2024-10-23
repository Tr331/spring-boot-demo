package com.example.student;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args -> {
            List<Student> students = List.of(new Student( "Jonas", "jonas@gmail.com", LocalDate.of(2000, 12, 10)),
                    new Student("Anna", "anna@gmail.com", LocalDate.of(2000, 7, 27)));
            studentRepository.saveAll(students);
        };
    }

}
