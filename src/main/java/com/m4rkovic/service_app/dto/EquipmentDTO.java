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
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentDTO {
    private Long id;

    @NotBlank(message = "Serial number is required")
    private String serialNumber;

    @NotBlank(message = "Model is required")
    private String model;

    private String manufacturer;

    @NotNull(message = "Category is required")
    private Long categoryId;

    private Long assignedToId;
    private LocalDateTime assignmentDate;
    private LocalDateTime returnDueDate;

    @NotNull(message = "Status is required")
    @Pattern(regexp = "^(IN_USE|PENDING_RETURN|RETURNED|MAINTENANCE)$", message = "Invalid status")
    private String status;

    private Map<String, String> specifications;
    private String notes;
    private boolean active = true;
}