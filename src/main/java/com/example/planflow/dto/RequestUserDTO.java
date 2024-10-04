package com.example.planflow.dto;

import com.example.planflow.models.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestUserDTO {

    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 4, max = 100)
    private String name;

    @NotBlank(message = "Surname is mandatory")
    @Size(min = 4, max = 100)
    private String surname;

    @NotBlank(message = "Email is mandatory")
    private String email;

    @Size(min = 4, max = 100)
    private String password;

    private Set<Role> roles;
}
