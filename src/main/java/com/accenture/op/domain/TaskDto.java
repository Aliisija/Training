package com.accenture.op.domain;

import java.util.Date;

public class TaskDto {

    private Long id;
    private String taskName;
    private Date startDate;
    private Date endDate;
    private String priority;
    private String notes;

    public TaskDto() {}

    public TaskDto(String taskName) {
        this.taskName = taskName;
    }

    public TaskDto(Long id, String taskName, Date startDate, Date endDate, String priority, String notes) {
        this.id = id;
        this.taskName = taskName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public TaskDto setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public TaskDto setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public TaskDto setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getPriority() {
        return priority;
    }

    public TaskDto setPriority(String priority) {
        this.priority = priority;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public TaskDto setNotes(String notes) {
        this.notes = notes;
        return this;
    }
}