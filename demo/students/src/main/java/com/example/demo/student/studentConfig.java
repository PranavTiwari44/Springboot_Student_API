package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class studentConfig {

    @Bean
    CommandLineRunner commandLineRunner(studentRepository repository){
        return args -> {
            student john = new student(
                    "JohnAppleseed",
                    LocalDate.of(1999, Month.DECEMBER, 1),
                    "johnappleseed@icloud.com"
            );
            student maria = new student(
                    "MariaAppleseed",
                    LocalDate.of(2000, Month.JANUARY, 9),
                    "mariaappleseed@icloud.com"
            );

            repository.saveAll(
                    List.of(john, maria)
            );
        };
    }
}
