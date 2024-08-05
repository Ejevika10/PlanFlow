package com.example.planflow.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {
    Urgent("Urgent"),
    High("High"),
    Normal("Normal"),
    Low("Low");

    private final String priority;
    Priority(String priority) {
        this.priority = priority;
    }
    @JsonValue
    public String getPriority() {
        return priority;
    }

    @JsonCreator
    public static Priority fromValue(String value) {
        for (Priority priority : values()) {
            String currentState = priority.getPriority();
            if (currentState.equals(value)) {
                return priority;
            }
        }

        // Return a response entity with a 400 Bad Request status
        throw new IllegalArgumentException("Invalid value for State Enum: " + value);
    }
}
