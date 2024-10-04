package com.example.planflow.dto;

import com.example.planflow.models.Task;
import com.example.planflow.models.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBoardDTO {
    private Long id;

    private String name;

    private String description;

    private ResponseUserDTO creator;

    private List<ResponseUserDTO> assignees;
}
