package com.accenture.op.task_domain.services.mapper;

import com.accenture.op.task_domain.entities.Object;
import com.accenture.op.task_domain.entities.entityDto.ObjectDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ObjectMapper {
    ObjectMapper INSTANCE = Mappers.getMapper(ObjectMapper.class);
    ObjectDTO objectToObjectDTO(Object object);

}
