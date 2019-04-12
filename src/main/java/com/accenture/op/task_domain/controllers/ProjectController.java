package com.accenture.op.task_domain.controllers;

import com.accenture.op.task_domain.entities.Project;
import com.accenture.op.task_domain.entities.entityDto.ProjectDTO;
import com.accenture.op.task_domain.services.ProjectService;
import com.accenture.op.task_domain.services.mapper.ProjectMapper;
import javafx.scene.shape.Path;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ProjectController {

    private ProjectMapper projectMapper;
    private ProjectService projectService;

    public ProjectController(ProjectMapper projectMapper, ProjectService projectService) {
        this.projectMapper = projectMapper;
        this.projectService = projectService;
    }


    @RequestMapping("/index")
    public String projects(){
        return "project index";
    }

   @GetMapping("/projects")
    public List<ProjectDTO> project(){
        return projectService.getAllProjects();
    }

    @GetMapping(value="project/{id}")
    public ProjectDTO getByID(@PathVariable("id")Long id){
        return projectMapper.projectToProjectDTO(projectService.getProjectById(id));
    }


    @PostMapping("/projectSubmit")
    public ProjectDTO submitProject(@RequestBody ProjectDTO projectDTO) {
        if(projectDTO.getDateCreated()==null){
            projectDTO.setDateCreated(new Date());
        }
        Project project = projectMapper.projectDTOToProject(projectDTO);
        Project projectCreated = projectService.save(project);
        return projectMapper.projectToProjectDTO(projectCreated);

    }
    //TODO, actually make this work...
    @PostMapping(value="project/update/{id}")
    public  ProjectDTO updateProject(@PathVariable("id")Long id,@RequestBody ProjectDTO projectDTO){


        Project project = projectMapper.projectDTOToProject(projectDTO);
        Project projectUpdated = projectService.updateProject(project.getId(),project);
        return projectMapper.projectToProjectDTO(projectUpdated);
    }

}
