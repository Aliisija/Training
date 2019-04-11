package com.accenture.op.task_domain.services.mapper;

import com.accenture.op.task_domain.entities.Project;
import com.accenture.op.task_domain.entities.entityDto.ProjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends ObjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);
    ProjectDTO projectToProjectDTO(Project project);
}
