package com.accenture.op;

import com.accenture.op.domain.Task;
import com.accenture.op.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {


    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        SpringApplication.run(Application.class);

    }

    @Bean
    public CommandLineRunner demo(TaskRepository taskRepository) {
        return (args) -> {
            taskRepository.save(new Task("date", "status", "priority", "assignee", "notes"));
            taskRepository.save(new Task("date2", "status2", "priority2", "assignee2", "notes2"));
            taskRepository.save(new Task("date3", "status3", "priodfdfdfrity2", "assigndfee2", "notdfes2"));

            taskRepository.findAll().forEach(t -> {
                log.info("Customer: {}", t);
            });
        };
    }




}
