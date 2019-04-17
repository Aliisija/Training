package com.accenture.op.task_domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

@DataJpaTest
public class ServiceTests {
    private TaskService taskService;

    @MockBean
    private TaskRepository taskRepository;
    @MockBean
    private TaskMapper taskMapper;
    @MockBean
    private Task task;
    @MockBean
    private TaskDto taskDto;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        taskService = new TaskService(taskRepository, taskMapper);
    }

    @Test
    public void testGetAllTasks() {
        List<Task> tasks = new ArrayList<>();
        Mockito.when(taskRepository.findAll()).thenReturn(tasks);

        TaskDto taskDto = new TaskDto("Task1");
        List<TaskDto> dtos = new ArrayList<>();
        dtos.add(taskDto);

        Mockito.when(taskMapper.entityToDtoList(Mockito.any())).thenReturn(dtos);

        Mockito.verify(taskRepository, Mockito.times(1)).findAll();
        Mockito.verify(taskMapper, Mockito.times(1)).entityToDtoList(tasks);

        assertThat(taskService.getAllTasks().size() == 1);
    }

    @Test
    public void testSaveNewTask() {
        Mockito.doNothing().when(taskMapper).dtoToEntity(Mockito.any());
        Mockito.doNothing().when(taskRepository).save(Mockito.any());
        taskService.saveNewTask(taskDto);
        Mockito.verify(taskMapper, Mockito.times(1)).dtoToEntity(Mockito.any());
        Mockito.verify(taskRepository, Mockito.times(1)).save(Mockito.any());
    }

    @Test
    public void testDeleteTaskById() {
        Mockito.doNothing().when(taskRepository).deleteById(Mockito.anyLong());
        taskService.deleteTaskById(Mockito.anyLong());
        Mockito.verify(taskRepository, Mockito.times(1)).deleteById(Mockito.anyLong());
    }


}
