package com.example.planflow.mapper;

import com.example.planflow.dto.RequestSubtaskDTO;
import com.example.planflow.dto.ResponseSubtaskDTO;
import com.example.planflow.models.Subtask;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = SubtaskMapper.class)
public interface SubtaskListMapper {
    List<Subtask> toSubtaskList(List<RequestSubtaskDTO> subtasks);
    List<ResponseSubtaskDTO> toSubtaskRespDto(List<Subtask> subtasks);
}
