package com.example.planflow.mapper;

import com.example.planflow.dto.RequestUserDTO;
import com.example.planflow.dto.ResponseUserDTO;
import com.example.planflow.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    RequestUserDTO toReqDto(User user);
    ResponseUserDTO toRespDto(User user);
    User toUser(RequestUserDTO requestUserDTO);
    User toUser(ResponseUserDTO respDto);
}
