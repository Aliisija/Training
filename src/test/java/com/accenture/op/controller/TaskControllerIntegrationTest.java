package com.accenture.op.controller;

import com.accenture.op.domain.Task;
import com.accenture.op.domain.TaskDto;
import com.accenture.op.mapper.TaskMapper;
import com.accenture.op.repository.TaskRepository;
import com.accenture.op.service.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskControllerIntegrationTest {

    private TaskRepository repository = new TaskRepository("tasks.txt");
    private TaskMapper mapper = new TaskMapper();
    private TaskService taskService = new TaskService(repository, mapper);
    private TaskController controller = new TaskController(taskService);

    @Test
    public void getAll() throws IOException, ClassNotFoundException {
        TaskDto taskDto1 = new TaskDto();
        TaskDto taskDto2 = new TaskDto();
        TaskDto taskDto3 = new TaskDto();
        controller.saveNewTask(taskDto1);
        System.out.println(controller.getAll());
//        controller.saveNewTask(taskDto2);
//        controller.saveNewTask(taskDto3);
        assertEquals(1, controller.getAll());
    }

    @Test
    public void saveNewTask() {
    }

    @Test
    public void updateTask() {
    }

    @Test
    public void deleteTaskById() {
    }
}