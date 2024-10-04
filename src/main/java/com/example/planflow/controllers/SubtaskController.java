package com.example.planflow.controllers;

import com.example.planflow.dto.RequestSubtaskDTO;
import com.example.planflow.dto.ResponseSubtaskDTO;
import com.example.planflow.services.SubtaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subtasks")
public class SubtaskController {
    @Autowired
    SubtaskService subtaskService;

    @GetMapping
    public ResponseEntity<List<ResponseSubtaskDTO>> getAllSubtasks() {
        return new ResponseEntity<>(subtaskService.getAllSubtasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseSubtaskDTO> getSubtask(@PathVariable Long id) {
        ResponseSubtaskDTO subtask = subtaskService.getSubtaskById(id);
        return subtask != null ? new ResponseEntity<>(subtask, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ResponseSubtaskDTO> createSubtask(@RequestBody RequestSubtaskDTO requestSubtaskDTO){
        return new ResponseEntity<>(subtaskService.createSubtask(requestSubtaskDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseSubtaskDTO> updateSubtask(@RequestBody RequestSubtaskDTO requestSubtaskDTO){
        ResponseSubtaskDTO updatedSubtask = subtaskService.updateSubtask(requestSubtaskDTO);
        return updatedSubtask != null ? new ResponseEntity<>(updatedSubtask, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubtask(@PathVariable Long id){
        return subtaskService.deleteSubtask(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
