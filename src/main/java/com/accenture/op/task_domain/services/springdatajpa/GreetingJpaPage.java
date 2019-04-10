package com.accenture.op.task_domain.services.springdatajpa;

public class GreetingJpaPage {

    private final long id;
    private final String helloString;

    public GreetingJpaPage(long id, String content) {
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
