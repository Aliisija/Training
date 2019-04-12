package com.accenture.op.mapper;
import com.accenture.op.domain.Task;
import com.accenture.op.domain.TaskDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TaskMapper {


    public List<Task> dtoToEntityList(final List<TaskDto> dtos){
        List<Task> entities = new ArrayList<>();

        for (TaskDto dto : dtos) {
            Task task = dtoToEntity(dto);
            entities.add(task);
        }
        return entities;
    }

    public List<TaskDto> entityToDtoList(final List<Task> entities) throws IndexOutOfBoundsException{
        List<TaskDto> dtos = new ArrayList<>();

        for (Task entity : entities) {
            TaskDto taskDto = entityToDto(entity);
            dtos.add(taskDto);
        }
        return dtos;
    }

    public Task dtoToEntity(final TaskDto taskDto) {
        Task task = new Task();
        task.setTaskName(taskDto.getTaskName());
        task.setStartDate(taskDto.getStartDate());
        task.setEndDate(taskDto.getEndDate());
        task.setNotes(taskDto.getNotes());
        task.setPriority(taskDto.getPriority());
        return task;
    }

    public TaskDto entityToDto(final Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setTaskName(task.getTaskName());
        taskDto.setStartDate(task.getStartDate());
        taskDto.setEndDate(task.getEndDate());
        taskDto.setNotes(task.getNotes());
        taskDto.setPriority(task.getPriority());
        return taskDto;
    }

    public void updateTask(TaskDto taskDto, Task taskToUpdate){
        taskToUpdate.setTaskName(taskDto.getTaskName());
        taskToUpdate.setStartDate(taskDto.getStartDate());
        taskToUpdate.setEndDate(taskDto.getEndDate());
        taskToUpdate.setNotes(taskDto.getNotes());
        taskToUpdate.setPriority(taskDto.getPriority());
    }
}