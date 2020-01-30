package com.accenture.op.task_domain;

import com.accenture.op.domain.Task;
import com.accenture.op.domain.TaskDto;
import com.accenture.op.mapper.TaskMapper;
import com.accenture.op.repository.TaskRepository;
import com.accenture.op.service.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class ServiceTests {
    private TaskService taskService;

    private TaskRepository taskRepository;
    private TaskMapper taskMapper;
    private Task task;
    private TaskDto taskDto;

    @Before
    public void init() {
        taskRepository = mock(TaskRepository.class);
        taskMapper = mock(TaskMapper.class);
        task = mock(Task.class);
        taskDto = mock(TaskDto.class);
        MockitoAnnotations.initMocks(this);
        taskService = new TaskService(taskRepository, taskMapper);
    }

    @Test
    public void testGetAllTasks() {
        List<Task> tasks = new ArrayList<>();
        when(taskRepository.findAll()).thenReturn(tasks);

        TaskDto dto = new TaskDto("Task1");
        List<TaskDto> dtos = new ArrayList<>();
        dtos.add(dto);

        when(taskMapper.entityToDtoList(any())).thenReturn(dtos);

        assertThat(taskService.getAllTasks().size() == 1);

        verify(taskRepository, Mockito.times(1)).findAll();
        verify(taskMapper, Mockito.times(1)).entityToDtoList(tasks);
    }

    @Test
    public void testSaveNewTask() {
        when(taskMapper.dtoToEntity(any())).thenReturn(new Task());
        when(taskRepository.save(any())).thenReturn(new Task());
        taskService.saveNewTask(taskDto);
        verify(taskMapper, Mockito.times(1)).dtoToEntity(any());
        verify(taskRepository, Mockito.times(1)).save(any());
    }

    @Test
    public void testUpdateTask() {
        when(taskRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(task));
        doNothing().when(taskMapper).updateTask(any(TaskDto.class), any(Task.class));
        when(taskRepository.save(any())).thenReturn(new Task());
        taskService.updateTask(new TaskDto(), 1L);
        verify(taskRepository, Mockito.times(1)).findById(1L);
        verify(taskMapper, Mockito.times(1)).updateTask(any(), any());
        verify(taskRepository, Mockito.times(1)).save(any());
    }

    @Test
    public void testDeleteTaskById() {
        doNothing().when(taskRepository).deleteById(Mockito.anyLong());
        taskService.deleteTaskById(Mockito.anyLong());
        verify(taskRepository, Mockito.times(1)).deleteById(Mockito.anyLong());
    }


}
