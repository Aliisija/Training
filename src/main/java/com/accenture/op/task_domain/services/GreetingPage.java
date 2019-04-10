package com.accenture.op.task_domain.services;

public class GreetingPage {

    private final long id;
    private final String helloString;

    public GreetingPage(long id, String content) {
        this.id = id;
        this.helloString = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return helloString;
    }
}
