package com.th.taskproject.services;

import com.th.taskproject.entities.Task;
import com.th.taskproject.exceptions.ResourceNotFoundException;
import com.th.taskproject.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    public Task findTaskById(Long id){
        return taskRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task){
        Task updatedTask = findTaskById(id);
        updatedTask.setTitle(task.getTitle());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setPriority(task.getPriority());

        return taskRepository.save(updatedTask);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }
}
