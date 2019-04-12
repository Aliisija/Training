package com.accenture.op.service;
import com.accenture.op.domain.TaskDto;
import com.accenture.op.mapper.TaskMapper;
import com.accenture.op.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.accenture.op.domain.Task;
import java.util.List;
import javax.persistence.EntityNotFoundException;

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
        return dtos;
    }

    public void saveNewTask(TaskDto dto){
        Task task = taskMapper.dtoToEntity(dto);
        taskRepository.save(task);
        System.out.println("Task saved.");
    }

    public void updateTask(TaskDto taskDto, Long id){
        Task task = taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException());
        taskMapper.updateTask(taskDto, task);
        taskRepository.save(task);
        System.out.println("Task updated.");
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
        System.out.println("Task deleted.");
    }
}
