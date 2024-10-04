package com.example.planflow.mapper;

import com.example.planflow.dto.RequestTaskDTO;
import com.example.planflow.dto.RequestUserDTO;
import com.example.planflow.dto.ResponseTaskDTO;
import com.example.planflow.dto.ResponseUserDTO;
import com.example.planflow.models.Task;
import com.example.planflow.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {UserMapper.class, BoardMapper.class})
public interface TaskMapper {
    RequestTaskDTO toReqDto(Task task);
    ResponseTaskDTO toRespDto(Task task);
    Task toTask(RequestTaskDTO reqDTO);
    Task toTask(ResponseTaskDTO respDTO);
}
