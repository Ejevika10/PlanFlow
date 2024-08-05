package com.example.planflow.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum State {
    ToDo("To do"),
    InProgress("In progress"),
    NeedsReview("Needs review"),
    Complete("Complete");

    private final String state;
    State(String state) {
        this.state = state;
    }
    @JsonValue
    public String getState() {
        return state;
    }

    @JsonCreator
    public static State fromValue(String value) {
        for (State state : values()) {
            String currentState = state.getState();
            if (currentState.equals(value)) {
                return state;
            }
        }

        // Return a response entity with a 400 Bad Request status
        throw new IllegalArgumentException("Invalid value for State Enum: " + value);
    }
}
