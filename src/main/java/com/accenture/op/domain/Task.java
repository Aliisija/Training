package com.accenture.op.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity(name = "TASK")
public class Task {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TASKNAME")
    private String taskName;
    @Column(name = "STARTDATE")
    @Temporal(value= TemporalType.TIMESTAMP)
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

    public Task setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Task setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Task setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public Task setPriority(String priority) {
        this.priority = priority;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Task setNotes(String notes) {
        this.notes = notes;
        return this;
    }
}