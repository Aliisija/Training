package com.accenture.op.controller;

import com.accenture.op.domain.TaskDto;
import com.accenture.op.service.TaskService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/savetask")
    public void saveNewTask(@RequestBody TaskDto dto) {
        taskService.saveNewTask(dto);
    }

    @PostMapping(value = "/updateTask")
    public void updateTask(@RequestBody TaskDto dto, Long id){
        taskService.updateTask(dto,id);
    }

    @DeleteMapping(value = "/deletetask")
    public void deleteTaskById(Long id){
        taskService.deleteTaskById(id);
    }

}