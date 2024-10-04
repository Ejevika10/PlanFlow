package com.example.planflow.services;

import com.example.planflow.dto.RequestTaskDTO;
import com.example.planflow.dto.ResponseTaskDTO;

import java.util.List;

public interface TaskService {
    List<ResponseTaskDTO> getAllTasks();
    List<ResponseTaskDTO> getAllTasksByUserId(Long userId);
    ResponseTaskDTO getTaskById(Long taskId);
    ResponseTaskDTO createTask(RequestTaskDTO requestTaskDTO);
    ResponseTaskDTO updateTask(RequestTaskDTO requestTaskDTO);
    boolean deleteTask(Long taskId);
}
