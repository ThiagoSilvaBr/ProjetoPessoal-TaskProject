package com.th.taskproject.services;

import com.th.taskproject.dtos.TaskCreateDTO;
import com.th.taskproject.dtos.TaskGetDTO;
import com.th.taskproject.dtos.TaskUpdateDTO;
import com.th.taskproject.entities.Category;
import com.th.taskproject.entities.Task;
import com.th.taskproject.entities.User;
import com.th.taskproject.exceptions.ResourceNotFoundException;
import com.th.taskproject.repositories.CategoryRepository;
import com.th.taskproject.repositories.TaskRepository;
import com.th.taskproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private TaskGetDTO convertToDTO(Task task) {
        return new TaskGetDTO(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),

                task.getUser().getId(),
                task.getUser().getName(),

                task.getCategory().getId(),
                task.getCategory().getName()
        );
    }

    public List<TaskGetDTO> findAllTasks() {
        return taskRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public TaskGetDTO findTaskById(Long id) {
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        return convertToDTO(task);
    }

    public TaskGetDTO saveTask(TaskCreateDTO dto) {

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUserId()));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + dto.getCategoryId()));

        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());

        task.setUser(user);
        task.setCategory(category);

        Task savedTask = taskRepository.save(task);
        return convertToDTO(savedTask);
    }

    public TaskGetDTO updateTask(Long id, TaskUpdateDTO dto) {

        Task task = taskRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Task not found with id: " + id));

        Category category  = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + dto.getCategoryId()));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + dto.getUserId()));

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setUser(user);
        task.setCategory(category);

        Task updatedTask = taskRepository.save(task);

        return convertToDTO(updatedTask);

    }

    public void deleteTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Task not found with id: " + id));

        taskRepository.delete(task);
    }
}
