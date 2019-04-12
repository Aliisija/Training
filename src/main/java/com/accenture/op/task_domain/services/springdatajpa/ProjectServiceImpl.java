package com.accenture.op.task_domain.services.springdatajpa;

import com.accenture.op.task_domain.entities.Project;
import com.accenture.op.task_domain.entities.entityDto.ProjectDTO;
import com.accenture.op.task_domain.repositories.ProjectRepository;
import com.accenture.op.task_domain.services.ProjectService;
import com.accenture.op.task_domain.services.mapper.ProjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Math.toIntExact;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return projectRepository
                .findAll()
                .stream()
                .map(projects -> {ProjectDTO projectDTO = projectMapper.projectToProjectDTO(projects);
                    //projectDTO.setProjectUrl("/api/project/" +projects.getId());
                    return projectDTO;
                }).collect(Collectors.toList());
    }


    @Override
    public ProjectDTO getProjectById(Long id) {
        return projectRepository.findById(id)
                .map(projectMapper::projectToProjectDTO)
                .orElseThrow(RuntimeException::new);//TODO, change this
    }

    @Override
    public Project save(Project project) {
        projectRepository.findAll().add(project);
        return projectRepository.save(project);

    }
    //TODO, make this work
    @Override
    public Project updateProject(Long id, Project project) {


        projectRepository.findAll().set(toIntExact(id), project);
        return projectRepository.save(project);
    }
}
