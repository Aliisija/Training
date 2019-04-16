package com.accenture.op.task_domain.entities.entityDto;


import com.accenture.op.task_domain.entities.Project;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;


@Data
@Entity
public class ProjectDTO extends Project implements Serializable {

}
