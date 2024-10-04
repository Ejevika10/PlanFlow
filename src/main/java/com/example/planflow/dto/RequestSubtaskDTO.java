package com.example.planflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestSubtaskDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 4, max = 100)
    private String name;

    private boolean isComplete;

    private RequestTaskDTO task;
}
