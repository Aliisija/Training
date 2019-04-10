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

    //private jo pagaidaam neizmantojam aarpus mapper klases, kad izmantosim - paarmainiit uz public.
    private Task dtoToEntity(final TaskDto taskDto) {
        Task task = new Task();
        task.setAssignee(taskDto.getAssignee());
        task.setDueDate(taskDto.getDueDate());
        task.setNotes(taskDto.getNotes());
        task.setPriority(taskDto.getPriority());
        task.setStatus(taskDto.getStatus());
        return task;
    }

    private TaskDto entityToDto(final Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setAssignee(task.getAssignee());
        taskDto.setDueDate(task.getDueDate());
        taskDto.setNotes(task.getNotes());
        taskDto.setPriority(task.getPriority());
        taskDto.setStatus(task.getStatus());
        return taskDto;
    }

}