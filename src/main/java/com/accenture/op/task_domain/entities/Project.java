package com.accenture.op.task_domain.entities;

import com.accenture.op.task_domain.entities.Object;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Project extends Object {

    private String title;
    private String body;
    private Date dateCreated;
    private boolean critical;
    private Long timeRemaining;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    public Long getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(Long timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
}
