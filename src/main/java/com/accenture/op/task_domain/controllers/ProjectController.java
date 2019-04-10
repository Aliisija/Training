package com.accenture.op.task_domain.controllers;

import com.accenture.op.task_domain.entities.Project;
import com.accenture.op.task_domain.services.springdatajpa.ProjectCrudService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProjectController {

    private ProjectCrudService projectService;
    public ProjectController(ProjectCrudService projectService){
        this.projectService = projectService;
    }

    @RequestMapping("/index")
    public String projects(){
        return "project index";
    }
    @GetMapping("/projects")
    public List<Project> project(){
        return projectService.findAll();
    }
    @PostMapping("/projectSubmit")
    public void submitProject(@RequestBody Project project) {
        if(project.getDateCreated()==null){
            project.setDateCreated(new Date());
        }
        projectService.save(project);

    }

}
