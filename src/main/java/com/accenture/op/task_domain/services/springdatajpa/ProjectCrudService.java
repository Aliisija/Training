package com.accenture.op.task_domain.services.springdatajpa;


import com.accenture.op.task_domain.entities.Project;
import com.accenture.op.task_domain.repositories.ProjectRepository;
import com.accenture.op.task_domain.services.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectCrudService implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectCrudService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll(){
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long aLong) {
        return projectRepository.findById(aLong).orElse(null);
    }

    @Override
    public Project save(Project object) {
        return projectRepository.save(object);
    }

    @Override
    public void delete(Project object) {
        projectRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        projectRepository.deleteById(aLong);

    }


/*
    public void insert(Project project) {
        projectRepository.save(project);
    }
  */
}
