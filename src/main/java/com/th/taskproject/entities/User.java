package com.th.taskproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be NULL")
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @NotNull(message = "Email cannot be NULL")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be NULL")
    @Size(min = 8, message = "Password must have at least 8 characters")
    private String password;

    private LocalDateTime createdAt;
}
