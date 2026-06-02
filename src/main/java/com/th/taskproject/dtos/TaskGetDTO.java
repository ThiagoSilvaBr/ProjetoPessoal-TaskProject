package com.th.taskproject.dtos;

import com.th.taskproject.enums.EnumPriority;
import com.th.taskproject.enums.EnumStatus;

public class TaskGetDTO {

    private Long id;
    private String title;
    private String description;
    private EnumStatus status;
    private EnumPriority priority;

    private Long userId;
    private String userName;

    private Long categoryId;
    private String categoryName;

    public TaskGetDTO() {
    }

    public TaskGetDTO(Long id,
                      String title,
                      String description,
                      EnumStatus status,
                      EnumPriority priority,
                      Long userId, String userName,
                      Long categoryId,
                      String categoryName) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.userId = userId;
        this.userName = userName;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
