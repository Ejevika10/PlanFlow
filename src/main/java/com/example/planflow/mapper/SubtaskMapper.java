package com.example.planflow.mapper;


import com.example.planflow.dto.RequestSubtaskDTO;
import com.example.planflow.dto.ResponseSubtaskDTO;
import com.example.planflow.models.Subtask;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {TaskMapper.class})
public interface SubtaskMapper {
    RequestSubtaskDTO toReqDto(Subtask subtask);
    ResponseSubtaskDTO toRespDto(Subtask subtask);
    Subtask toSubtask(RequestSubtaskDTO requestSubtaskDTO);
    Subtask toSubtask(ResponseSubtaskDTO respSubtaskDTO);
}
