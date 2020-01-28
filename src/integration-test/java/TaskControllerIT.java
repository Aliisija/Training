import com.accenture.op.Application;
import com.accenture.op.domain.TaskDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {Application.class})
@ActiveProfiles(value = "integration")
public class TaskControllerIT {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void shouldReturnAllTasks() throws Exception {
        mvc.perform(get("/rest/tasks"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldSaveTask() throws Exception {
        TaskDto dto = createDto("Some task", "High", "Notes");

        mvc.perform(post("/rest/tasks")
                .contentType(APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dto)))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateTask() throws Exception {
        TaskDto dto1 = createDto("Some task", "High", "Notes");

        mvc.perform(post("/rest/tasks")
                .contentType(APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dto1)))
                .andExpect(status().isOk());

        TaskDto dto2 = createDto("Edited task", "Low", "Notes");

        mvc.perform(put("/rest/tasks/" + 1)
                .contentType(APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dto2)))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTaskById() throws Exception {
        TaskDto dto1 = createDto("Some task", "High", "Notes");

        mvc.perform(post("/rest/tasks")
                .contentType(APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dto1)))
                .andExpect(status().isOk());

        mvc.perform(delete("/rest/tasks/" + 1)
                .contentType(APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(dto1)))
                .andExpect(status().isOk());
    }

    //Auxiliary methods

    public TaskDto createDto(String name, String priority, String notes){
        TaskDto dto = new TaskDto();
        dto.setTaskName(name);
        dto.setPriority(priority);
        dto.setNotes(notes);
        dto.setStartDate(new Date());
        dto.setEndDate(new Date());
        return dto;
    }
}