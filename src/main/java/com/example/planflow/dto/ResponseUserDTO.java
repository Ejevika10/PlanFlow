package com.example.planflow.dto;

import com.example.planflow.models.Role;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserDTO {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String password;

    private Set<Role> roles;
}
