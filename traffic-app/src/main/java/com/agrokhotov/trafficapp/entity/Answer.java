package com.agrokhotov.trafficapp.entity;

public class Answer {

    private String description;
    private Long counter;

    public Answer(String description, Long counter) {
        this.counter = counter;
        this.description = description;
    }

    public Long getCounter() {
        return counter;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "description='" + description + '\'' +
                ", counter=" + counter +
                '}';
    }
}
