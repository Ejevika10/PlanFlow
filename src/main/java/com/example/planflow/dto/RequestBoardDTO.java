package com.example.planflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestBoardDTO {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 4, max = 100)
    private String name;

    @NotBlank(message = "Description is mandatory")
    @Size(min = 4, max = 100)
    private String description;

    private RequestUserDTO creator;

    private List<RequestUserDTO> assignees;
}
