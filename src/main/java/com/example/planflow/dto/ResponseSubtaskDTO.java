package com.example.planflow.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSubtaskDTO {
    private Long id;

    private String name;

    private boolean isComplete;

    private ResponseTaskDTO task;
}
