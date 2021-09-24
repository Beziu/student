package com.myproject.student.datasource;

import com.myproject.student.dao.StudentRepository;
import com.myproject.student.model.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student ebi = new Student(
                    "Ebi",
                    "ebi@gmail.com",
                    LocalDate.of(2010, MAY, 19)
            );

            Student kaci = new Student(
                    "Kaci",
                    "kaci@gmail.com",
                    LocalDate.of(2006, APRIL, 18)
            );

            repository.saveAll(List.of(ebi, kaci));

        };
    }
}
