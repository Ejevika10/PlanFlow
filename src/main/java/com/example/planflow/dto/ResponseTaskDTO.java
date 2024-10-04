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
public class ResponseTaskDTO {
    private Long id;

    private String name;

    private String description;

    private State state;

    private Date startDate;

    private Date lastDate;

    private String timeEstimate;

    private Priority priority;

    private List<ResponseUserDTO> assignees;

    private ResponseBoardDTO board;
}
