package com.th.taskproject.dtos;

import jakarta.validation.constraints.NotBlank;

public class CategoryUpdateDTO {

    @NotBlank
    private String name;

    public CategoryUpdateDTO() {
    }

    public CategoryUpdateDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
