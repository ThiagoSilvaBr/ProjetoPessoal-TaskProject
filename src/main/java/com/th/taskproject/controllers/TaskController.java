package com.th.taskproject.controllers;

import com.th.taskproject.dtos.TaskCreateDTO;
import com.th.taskproject.dtos.TaskGetDTO;
import com.th.taskproject.dtos.TaskUpdateDTO;
import com.th.taskproject.entities.Task;
import com.th.taskproject.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskGetDTO>> getAllTasks(){
        List<TaskGetDTO> request = taskService.findAllTasks();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskGetDTO> getTaskById(@PathVariable Long id){
        TaskGetDTO request = taskService.findTaskById(id);
        return ResponseEntity.ok().body(request);
    }

    @PostMapping
    public ResponseEntity<TaskGetDTO> createTask(@Valid @RequestBody TaskCreateDTO dto){
        TaskGetDTO request = taskService.saveTask(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskGetDTO> updateTask(@PathVariable Long id, @Valid @RequestBody TaskUpdateDTO dto){
        TaskGetDTO request = taskService.updateTask(id, dto);
        return ResponseEntity.ok(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTaskById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }
}
