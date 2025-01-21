package com.m4rkovic.service_app.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]*$", message = "Invalid phone number format")
    private String phone;

    private String title;
    private String function;
    private Long companyId;
    private String department;
    private String building;
    private Long locationId;
    private Long supervisorId;
    private Long employerId;
    private String language;
    private LocalDateTime lastLogin;
    private String details;

    @NotNull(message = "Role is required")
    @Pattern(regexp = "^(SUPER_ADMIN|ADMIN|GROUP_MANAGER|TECHNICIAN|USER)$", message = "Invalid role")
    private String role;

    private boolean active = true;
}
