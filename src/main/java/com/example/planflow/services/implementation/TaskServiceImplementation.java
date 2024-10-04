package com.example.planflow.services.implementation;

import com.example.planflow.dto.RequestTaskDTO;
import com.example.planflow.dto.ResponseTaskDTO;
import com.example.planflow.mapper.TaskListMapper;
import com.example.planflow.mapper.TaskMapper;
import com.example.planflow.models.Task;
import com.example.planflow.repositories.TaskRepository;
import com.example.planflow.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImplementation implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private TaskListMapper taskListMapper;

    @Override
    public List<ResponseTaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return taskListMapper.toTaskRespDto(tasks);
    }

    @Override
    public List<ResponseTaskDTO> getAllTasksByUserId(Long userId) {
        List<Task> tasks = taskRepository.findAllByUserId(userId);
        return taskListMapper.toTaskRespDto(tasks);
    }

    @Override
    public ResponseTaskDTO getTaskById(Long taskId) {
        Task task = taskRepository.findById(taskId).orElse(null);
        return taskMapper.toRespDto(task);
    }

    @Override
    public ResponseTaskDTO createTask(RequestTaskDTO requestTaskDTO) {
        Task task = taskRepository.save(taskMapper.toTask(requestTaskDTO));
        return taskMapper.toRespDto(task);
    }

    @Override
    public ResponseTaskDTO updateTask(RequestTaskDTO requestTaskDTO) {
        if(taskRepository.existsById(requestTaskDTO.getId())) {
            Task task = taskRepository.save(taskMapper.toTask(requestTaskDTO));
            return taskMapper.toRespDto(task);
        }
        return null;
    }

    @Override
    public boolean deleteTask(Long taskId) {
        if(taskRepository.existsById(taskId)) {
            taskRepository.deleteById(taskId);
            return true;
        }
        return false;
    }
}
