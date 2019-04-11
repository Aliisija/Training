package com.accenture.op.task_domain.services.mapper;


import com.accenture.op.task_domain.entities.Object;
import com.accenture.op.task_domain.entities.entityDto.ObjectDTO;
import org.junit.Assert;
import org.junit.Test;

public class ObjectMapperTest {
    ObjectMapper objectMapper = ObjectMapper.INSTANCE;

    @Test
    public void objectToObjectDTO() throws Exception {
        Object object = new Object();
        object.setId(3L);

        ObjectDTO objectDTO = objectMapper.objectToObjectDTO(object);

        Assert.assertEquals(Long.valueOf(3L), objectDTO.getId());
    }

}