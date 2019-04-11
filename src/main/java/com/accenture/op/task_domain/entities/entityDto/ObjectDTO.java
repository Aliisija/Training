package com.accenture.op.task_domain.entities.entityDto;

import lombok.Data;

@Data
public class ObjectDTO {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
