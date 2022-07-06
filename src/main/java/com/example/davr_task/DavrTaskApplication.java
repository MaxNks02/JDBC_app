package com.example.davr_task;

import com.example.davr_task.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class DavrTaskApplication {



    public static void main(String[] args) {
        SpringApplication.run(DavrTaskApplication.class, args);
    }

}
