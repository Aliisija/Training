package com.accenture.op.task_domain.services.mapper;

import com.accenture.op.task_domain.entities.Project;
import com.accenture.op.task_domain.entities.entityDto.ProjectDTO;
import javafx.scene.layout.BackgroundImage;
import org.junit.Assert;
import org.junit.Test;



public class ProjectMapperTest {

        ProjectMapper objectMapper = ProjectMapper.INSTANCE;

        @Test
        public void objectToObjectDTO() throws Exception {
            Project project = new Project();
            project.setId(3L);
            project.setCritical(true);



            ProjectDTO projectDTO = objectMapper.projectToProjectDTO(project);

            Assert.assertEquals(Long.valueOf(3L), projectDTO.getId());
            Assert.assertEquals(Long.valueOf(1L), projectDTO.getTimeRemaining());
            Assert.assertEquals(Boolean.valueOf(true), projectDTO.isCritical());
        }

}