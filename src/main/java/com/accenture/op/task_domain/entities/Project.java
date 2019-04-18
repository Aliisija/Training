package com.accenture.op.task_domain.entities;




import lombok.Data;

import javax.persistence.*;
import java.util.Date;



@Data
@Entity

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private Date dateCreated;
    private boolean critical;



    private Date timeRemaining;
    private String editUrl;
    private String deleteUrl;
    private String doneUrl;




    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
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

    public Date getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(Date timeRemaining) {
        this.timeRemaining = timeRemaining;
    }
    public String getEditUrl() {
        return editUrl;
    }

    public void setEditUrl(String editUrl) {
        this.editUrl = editUrl;
    }

    public String getDeleteUrl() {
        return deleteUrl;
    }

    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    public String getDoneUrl() {
        return doneUrl;
    }

    public void setDoneUrl(String doneUrl) {
        this.doneUrl = doneUrl;
    }
}
