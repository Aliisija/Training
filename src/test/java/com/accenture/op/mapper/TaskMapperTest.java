package com.accenture.op.mapper;

import com.accenture.op.domain.Task;
import com.accenture.op.domain.TaskDto;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    private TaskMapper taskMapper = new TaskMapper();

    @Test
    public void dtoToEntityList() {
        final List<TaskDto> taskDtos = new ArrayList<>();
        TaskDto taskDto1 = new TaskDto();
        TaskDto taskDto2 = new TaskDto();
        taskDtos.add(taskDto1);
        taskDtos.add(taskDto2);
        List<Task> tasks = taskMapper.dtoToEntityList(taskDtos);
        assertEquals(tasks.size(), taskDtos.size());
    }

    @Test
    public void entityToDtoList() {
        final List<Task> tasks = new ArrayList<>();
        Task task1 = new Task();
        Task task2 = new Task();
        tasks.add(task1);
        tasks.add(task2);
        List<TaskDto> taskDtos = taskMapper.entityToDtoList(tasks);
        assertEquals(tasks.size(), taskDtos.size());
    }

    @Test
    public void updateTask() {
        TaskDto taskDto = new TaskDto();
        Date startDate = new Date();
        Date endDate = new Date();
        taskDto.setStartDate(startDate);
        taskDto.setEndDate(endDate);
        taskDto.setNotes("Some notes");
        taskDto.setPriority("High");
        taskDto.setTaskName("Task name");
        Task task = new Task();
        taskMapper.updateTask(taskDto, task);
        assertEquals(task.getStartDate(), startDate);
        assertEquals(task.getEndDate(), endDate);
        assertEquals(task.getNotes(), "Some notes");
        assertEquals(task.getPriority(), "High");
        assertEquals(task.getTaskName(), "Task name");
    }
}