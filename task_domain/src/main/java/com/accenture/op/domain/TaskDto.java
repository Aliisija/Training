package com.accenture.op.domain;

public class TaskDto {

    private String dueDate;
    private String status;
    private String priority;
    private String assignee;
    private String notes;

    public TaskDto() {}

    public TaskDto(String dueDate, String status, String priority, String assignee, String notes) {
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
        this.notes = notes;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}