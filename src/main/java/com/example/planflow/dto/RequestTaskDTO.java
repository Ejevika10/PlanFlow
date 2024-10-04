package com.example.planflow.dto;


import com.example.planflow.models.Priority;
import com.example.planflow.models.State;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTaskDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 4, max = 100)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 4, max = 100)
    private String description;

    private State state;

    private Date startDate;

    private Date lastDate;

    private String timeEstimate;

    private Priority priority;

    private List<RequestUserDTO> assignees;

    private RequestBoardDTO board;
}
