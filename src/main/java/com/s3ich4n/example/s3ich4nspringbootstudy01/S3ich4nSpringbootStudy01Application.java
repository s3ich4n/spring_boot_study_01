package com.s3ich4n.example.s3ich4nspringbootstudy01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class S3ich4nSpringbootStudy01Application {

    public static void main(String[] args) {
        SpringApplication.run(S3ich4nSpringbootStudy01Application.class, args);
    }
}
