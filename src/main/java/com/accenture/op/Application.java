package com.accenture.op;

import com.accenture.op.controller.TaskController;
import com.accenture.op.domain.Task;
import com.accenture.op.domain.TaskDto;
import com.accenture.op.mapper.TaskMapper;
import com.accenture.op.repository.TaskRepository;
import com.accenture.op.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class Application {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SpringApplication.run(Application.class);
        TaskService taskService = new TaskService(new TaskRepository("tasksMain.txt"), new TaskMapper());
        TaskController controller = new TaskController(taskService);
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskName("smth");
        controller.saveNewTask(taskDto);

        System.out.println(controller.getAll());
    }
}
