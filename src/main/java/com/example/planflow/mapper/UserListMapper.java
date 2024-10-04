package com.example.planflow.mapper;

import com.example.planflow.dto.RequestUserDTO;
import com.example.planflow.dto.ResponseUserDTO;
import com.example.planflow.models.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserListMapper.class)
public interface UserListMapper {
    List<User> toUserList(List<RequestUserDTO> users);
    List<ResponseUserDTO> toUserRespList(List<User> users);
}
