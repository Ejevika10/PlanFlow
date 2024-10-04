package com.example.planflow.services.implementation;

import com.example.planflow.dto.RequestSubtaskDTO;
import com.example.planflow.dto.ResponseSubtaskDTO;
import com.example.planflow.mapper.SubtaskListMapper;
import com.example.planflow.mapper.SubtaskMapper;
import com.example.planflow.models.Subtask;
import com.example.planflow.repositories.SubtaskRepository;
import com.example.planflow.services.SubtaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubtaskServiceImplementation implements SubtaskService {
    @Autowired
    private SubtaskRepository subtaskRepository;
    @Autowired
    private SubtaskMapper subtaskMapper;
    @Autowired
    private SubtaskListMapper subtaskListMapper;

    @Override
    public List<ResponseSubtaskDTO> getAllSubtasks() {
        List<Subtask> subtasks = subtaskRepository.findAll();
        return subtaskListMapper.toSubtaskRespDto(subtasks);
    }

    @Override
    public List<ResponseSubtaskDTO> getAllSubtasksByTaskId(Long taskId) {
        List<Subtask> subtasks = subtaskRepository.findAllByTaskId(taskId);
        return subtaskListMapper.toSubtaskRespDto(subtasks);
    }

    @Override
    public ResponseSubtaskDTO getSubtaskById(Long subtaskId) {
        Subtask subtask = subtaskRepository.findById(subtaskId).orElse(null);
        return subtaskMapper.toRespDto(subtask);
    }

    @Override
    public ResponseSubtaskDTO createSubtask(RequestSubtaskDTO requestSubtaskDTO) {
        Subtask subtask = subtaskRepository.save(subtaskMapper.toSubtask(requestSubtaskDTO));
        return subtaskMapper.toRespDto(subtask);
    }

    @Override
    public ResponseSubtaskDTO updateSubtask(RequestSubtaskDTO requestSubtaskDTO) {
        if(subtaskRepository.existsById(requestSubtaskDTO.getId())) {
            Subtask subtask = subtaskRepository.save(subtaskMapper.toSubtask(requestSubtaskDTO));
            return subtaskMapper.toRespDto(subtask);
        }
        return null;
    }

    @Override
    public boolean deleteSubtask(Long subtaskId) {
        if(subtaskRepository.existsById(subtaskId)) {
            subtaskRepository.deleteById(subtaskId);
            return true;
        }
        return false;
    }
}
