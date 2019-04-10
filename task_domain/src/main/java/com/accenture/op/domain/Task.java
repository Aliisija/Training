package com.accenture.op.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column
    private String dueDate;
    @Column
    private String status;
    @Column
    private String priority;
    @Column
    private String assignee;
    @Column
    private String notes;

    public Task() {}

    public Task(String dueDate, String status) {
        this.dueDate = dueDate;
        this.status = status;
    }

    public Task(String dueDate, String status, String priority, String assignee, String notes) {
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
        this.notes = notes;
    }

    public Long getId(){
        return id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() { return status; }

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