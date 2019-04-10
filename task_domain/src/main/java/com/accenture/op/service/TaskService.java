package com.accenture.op.service;
import com.accenture.op.domain.TaskDto;
import com.accenture.op.mapper.TaskMapper;
import com.accenture.op.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.op.domain.Task;
import java.util.List;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDto> getAllTasks() {
        List<Task> allTasks = taskRepository.findAll();
        List<TaskDto> dtos = taskMapper.entityToDtoList(allTasks);
        System.out.println("DTOS: " + dtos);
        return dtos;
    }

}
