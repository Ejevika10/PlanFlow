package com.example.planflow.services;

import com.example.planflow.dto.RequestSubtaskDTO;
import com.example.planflow.dto.ResponseSubtaskDTO;

import java.util.List;

public interface SubtaskService {
    List<ResponseSubtaskDTO> getAllSubtasks();
    List<ResponseSubtaskDTO> getAllSubtasksByTaskId(Long taskId);
    ResponseSubtaskDTO getSubtaskById(Long subtaskId);
    ResponseSubtaskDTO createSubtask(RequestSubtaskDTO requestSubtaskDTO);
    ResponseSubtaskDTO updateSubtask(RequestSubtaskDTO requestSubtaskDTO);
    boolean deleteSubtask(Long subtaskId);
}
