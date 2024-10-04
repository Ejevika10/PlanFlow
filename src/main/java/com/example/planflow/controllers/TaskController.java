package com.example.planflow.controllers;

import com.example.planflow.dto.RequestSubtaskDTO;
import com.example.planflow.dto.RequestTaskDTO;
import com.example.planflow.dto.ResponseSubtaskDTO;
import com.example.planflow.dto.ResponseTaskDTO;
import com.example.planflow.services.SubtaskService;
import com.example.planflow.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @GetMapping
    public ResponseEntity<List<ResponseTaskDTO>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseTaskDTO> getTask(@PathVariable Long id) {
        ResponseTaskDTO task = taskService.getTaskById(id);
        return task != null ? new ResponseEntity<>(task, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ResponseTaskDTO> createTask(@RequestBody RequestTaskDTO requestTaskDTO){
        return new ResponseEntity<>(taskService.createTask(requestTaskDTO), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ResponseTaskDTO> updateTask(@RequestBody RequestTaskDTO requestTaskDTO){
        ResponseTaskDTO updatedTask = taskService.updateTask(requestTaskDTO);
        return updatedTask != null ? new ResponseEntity<>(updatedTask, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        return taskService.deleteTask(id) ? new ResponseEntity<>(HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
