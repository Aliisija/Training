package com.accenture.op.task_domain.services;

import com.accenture.op.task_domain.entities.Project;
import com.accenture.op.task_domain.entities.entityDto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    List<ProjectDTO>getAllProjects();
    ProjectDTO getProjectById(Long id);
    Project save(Project project);
}
