package com.th.taskproject.dtos;

import com.th.taskproject.enums.EnumPriority;
import com.th.taskproject.enums.EnumStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskUpdateDTO {

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

    public TaskUpdateDTO() {
    }

    public TaskUpdateDTO(String title, String description, EnumStatus status, EnumPriority priority, Long categoryId, Long userId) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.categoryId = categoryId;
        this.userId = userId;
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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
