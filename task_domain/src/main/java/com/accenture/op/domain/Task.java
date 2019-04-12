package com.accenture.op.domain;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TASKNAME")
    private String taskName;
    @Column(name = "STARTDATE")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "ENDDATE")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "PRIORITY")
    private String priority;
    @Column(name = "NOTES")
    private String notes;

    public Task() {}

    public Task(String taskName, Date startDate, Date endDate, String priority, String notes) {
        this.taskName = taskName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.notes = notes;
    }

    public Long getId(){
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}