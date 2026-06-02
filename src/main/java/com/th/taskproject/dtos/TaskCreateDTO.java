package com.th.taskproject.dtos;

import com.th.taskproject.enums.EnumPriority;
import com.th.taskproject.enums.EnumStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskCreateDTO {

    @NotBlank
    private String title;
    @NotBlank
    private String description;

    @NotNull
    private EnumStatus status;
    @NotNull
    private EnumPriority priority;

    @NotNull
    private Long userId;
    @NotNull
    private Long categoryId;

    public TaskCreateDTO() {
    }

    public TaskCreateDTO(String title, String description, EnumStatus status, EnumPriority priority, Long userId, Long categoryId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.userId = userId;
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public EnumPriority getPriority() {
        return priority;
    }

    public void setPriority(EnumPriority priority) {
        this.priority = priority;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
