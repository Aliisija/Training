package com.accenture.op.task_domain.controllers;

import com.accenture.op.task_domain.domain.Project;
import com.accenture.op.task_domain.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    private ProjectService projectService;
    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @RequestMapping("/index")
    public String projects(){
        return "project index";
    }
    @GetMapping("/projects")
    public List<Project> project(){
        return projectService.getAllProjects();
    }
    @PostMapping("/projectSubmit")
    public void submitProject(@RequestBody Project project) {
        projectService.insert(project);
    }

}
