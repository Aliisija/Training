package com.accenture.op.controller;

import com.accenture.op.domain.Task;
import com.accenture.op.domain.TaskDto;
import com.accenture.op.repository.TaskRepository;
import com.accenture.op.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/tasks")
    public List<TaskDto> getAll() {
        return taskService.getAllTasks();
    }

//    @RequestMapping(value = "/")
//    public String hello() {
//        taskRepository.save(new Task("due date", "status"));
//        return "Test";
//
//    }

//    @GetMapping("/tasks")
//    public String getAll() {
//        return "Returning all tasks";
//    }

}
