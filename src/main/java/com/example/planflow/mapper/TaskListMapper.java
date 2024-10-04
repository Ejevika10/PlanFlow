package com.example.planflow.mapper;

import com.example.planflow.dto.RequestTaskDTO;
import com.example.planflow.dto.ResponseTaskDTO;
import com.example.planflow.models.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = TaskMapper.class)
public interface TaskListMapper {
    List<Task> toTaskList(List<RequestTaskDTO> tasks);
    List<ResponseTaskDTO> toTaskRespDto(List<Task> tasks);
}
