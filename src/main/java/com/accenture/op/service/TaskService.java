package com.accenture.op.service;
import com.accenture.op.domain.TaskDto;
import com.accenture.op.mapper.TaskMapper;
import com.accenture.op.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.op.domain.Task;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityNotFoundException;

@Service
public class TaskService {
    private static final Logger log = LoggerFactory.getLogger(TaskService.class);

    final private TaskRepository taskRepository;

    final private TaskMapper taskMapper;

    public TaskService(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    public List<TaskDto> getAllTasks() throws IOException, ClassNotFoundException {
        List<Task> allTasks = taskRepository.findAll();
        return taskMapper.entityToDtoList(allTasks);
    }

    public void saveNewTask(TaskDto dto) throws IOException {
        Task task = taskMapper.dtoToEntity(dto);
        taskRepository.save(task);
        log.info("Task saved.");
    }

//    public void updateTask(TaskDto taskDto, Long id){
//        Task task = taskRepository.findById(id).orElseThrow(EntityNotFoundException::new);
//        taskMapper.updateTask(taskDto, task);
//        taskRepository.save(task);
//        log.info("Task updated.");
//    }
//
//    public void deleteTaskById(Long id){
//        taskRepository.deleteById(id);
//        log.info("Task deleted.");
//    }
}
