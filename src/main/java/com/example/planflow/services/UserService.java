package com.example.planflow.services;

import com.example.planflow.dto.RequestSubtaskDTO;
import com.example.planflow.dto.RequestUserDTO;
import com.example.planflow.dto.ResponseSubtaskDTO;
import com.example.planflow.dto.ResponseUserDTO;

import java.util.List;

public interface UserService {

    List<ResponseUserDTO> getAllUsers();
    ResponseUserDTO getUserById(Long userId);
    ResponseUserDTO createUser(RequestUserDTO requestUserDTO);
    ResponseUserDTO updateUser(RequestUserDTO requestUserDTO);
    boolean deleteUser(Long userId);
    ResponseUserDTO getUserByEmail(String email);
}
