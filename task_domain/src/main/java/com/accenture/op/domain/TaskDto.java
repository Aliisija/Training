package com.accenture.op.domain;
import java.util.Date;

public class TaskDto {

    private String taskName;
    private Date startDate;
    private Date endDate;
    private String priority;
    private String notes;

    public TaskDto() {}

    public TaskDto(String taskName, Date startDate, Date endDate, String priority, String notes) {
        this.taskName = taskName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.priority = priority;
        this.notes = notes;
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