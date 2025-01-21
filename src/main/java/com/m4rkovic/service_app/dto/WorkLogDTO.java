package com.m4rkovic.service_app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkLogDTO {
    private Long id;

    @NotNull(message = "Incident ID is required")
    private Long incidentId;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 2000, message = "Description must be between 10 and 2000 characters")
    private String description;

    @NotNull(message = "Start time is required")
    private LocalDateTime startTime;

    private LocalDateTime endTime;
    private Integer timeSpentMinutes;

    @NotNull(message = "Worker ID is required")
    private Long workerId;

    @NotNull(message = "Work log type is required")
    @Pattern(regexp = "^(ANALYSIS|DEVELOPMENT|TESTING|COMMUNICATION|DOCUMENTATION|DEPLOYMENT|MAINTENANCE|SUPPORT)$",
            message = "Invalid work log type")
    private String type;

    private boolean billable;
}