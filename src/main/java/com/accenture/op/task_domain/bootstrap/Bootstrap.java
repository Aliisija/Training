package com.accenture.op.task_domain.bootstrap;


import com.accenture.op.task_domain.entities.Project;
import com.accenture.op.task_domain.services.ProjectService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bootstrap implements CommandLineRunner {
    private final ProjectService projectService;

    public Bootstrap(ProjectService projectService) {
        this.projectService = projectService;
    }
    @Override
    public void run(String... args) throws Exception {

        int size = projectService.getAllProjects().size();

        if (size == 0 ){
            loadData();
        }
    }
    private void loadData() {
        Project project = new Project();

        project.setTimeRemaining(new Date());
        project.setCritical(true);
        project.setTitle("First Loaded value");
        project.setBody("First Loaded body");
        project.setDateCreated(new Date());
        projectService.save(project);

        Project project2 = new Project();

        project2.setTimeRemaining(new Date());
        project2.setCritical(true);
        project2.setTitle("Second Loaded value");
        project2.setBody("Second Loaded body");
        project2.setDateCreated(new Date());

        projectService.save(project2);

        Project project3 = new Project();
        project3.setTimeRemaining(new Date());
        project3.setCritical(true);
        project3.setTitle("Third Loaded value");
        project3.setBody("Third Loaded body");
        project3.setDateCreated(new Date());

        projectService.save(project3);

        //projectService.updateProject(project.getId(),project2);

    }



}
