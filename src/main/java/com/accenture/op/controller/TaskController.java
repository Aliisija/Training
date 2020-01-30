package com.accenture.op.controller;

import com.accenture.op.domain.TaskDto;
import com.accenture.op.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping(value = "/rest/tasks")
    public List<TaskDto> getAll() {
        return taskService.getAllTasks();
    }

    @PostMapping(value = "/rest/tasks", consumes="application/json")
    public void saveNewTask(@RequestBody TaskDto dto) {
        taskService.saveNewTask(dto);
    }

    @PutMapping(value = "/rest/tasks/{id}", consumes="application/json")
    public void updateTask(@RequestBody TaskDto dto, @PathVariable Long id){
        log.info(String.valueOf(id));
        taskService.updateTask(dto,id);
    }

    @DeleteMapping(value = "/rest/tasks/{id}", consumes="application/json")
    public void deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
    }

}