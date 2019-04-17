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
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

    public List<TaskDto> entityToDtoList(final List<Task> entities){
        List<TaskDto> dtos = new ArrayList<>();

        for (Task entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    public Task dtoToEntity(final TaskDto taskDto) {
        Task task = new Task(taskDto.getTaskName(), taskDto.getStartDate(), taskDto.getEndDate(), taskDto.getPriority(), taskDto.getNotes());
        return task;
    }

    public static TaskDto entityToDto(final Task task) {
        TaskDto taskDto = new TaskDto(task.getId(), task.getTaskName(), task.getStartDate(), task.getEndDate(), task.getPriority(), task.getNotes());
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