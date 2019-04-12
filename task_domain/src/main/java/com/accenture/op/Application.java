package com.accenture.op;

import com.accenture.op.domain.Task;
import com.accenture.op.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Date;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(TaskRepository taskRepository) {
        return (args) -> {
            taskRepository.save(new Task("Task 1", new Date(), new Date(), "high", "Do ASAP"));
            taskRepository.save(new Task("Task 2", new Date(), new Date(), "low", "Don't bother"));
            taskRepository.save(new Task("Task 3", new Date(), new Date(), "high", "Just do it"));

            taskRepository.findAll().forEach(t -> {
                log.info("Customer: {}", t);
            });
        };
    }




}
