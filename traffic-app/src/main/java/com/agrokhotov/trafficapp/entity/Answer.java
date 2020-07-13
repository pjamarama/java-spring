package com.agrokhotov.trafficapp.entity;

public class Answer {

    private String description;
    private Long visitCounter;

    public Answer(String description, Long visitCounter) {
        this.visitCounter = visitCounter;
        this.description = description;
    }

    public Long getVisitCounter() {
        return visitCounter;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "description='" + description + '\'' +
                ", counter=" + visitCounter +
                '}';
    }
}
