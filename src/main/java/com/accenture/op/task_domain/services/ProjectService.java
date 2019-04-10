package com.accenture.op.task_domain.services;


import com.accenture.op.task_domain.domain.Project;
import com.accenture.op.task_domain.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    public void insert(Project project) {
        projectRepository.save(project);
    }
}
