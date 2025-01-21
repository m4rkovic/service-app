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
public class IncidentDTO {
    private Long id;

    @NotBlank(message = "Ticket number is required")
    private String ticketNumber;

    @NotBlank(message = "Title is required")
    @Size(min = 5, max = 200, message = "Title must be between 5 and 200 characters")
    private String title;

    @NotBlank(message = "Description is required")
    @Size(min = 10, max = 2000, message = "Description must be between 10 and 2000 characters")
    private String description;

    @NotNull(message = "Criticality is required")
    @Pattern(regexp = "^(LOW|MEDIUM|HIGH|CRITICAL|EMERGENCY)$", message = "Invalid criticality")
    private String criticality;

    @NotNull(message = "Status is required")
    @Pattern(regexp = "^(NEW|ASSIGNED|IN_PROGRESS|ON_HOLD|PENDING_CUSTOMER|RESOLVED|CLOSED|CANCELLED)$",
            message = "Invalid status")
    private String status;

    private Long reportedById;
    private Long assignedToId;
    private Long assignedGroupId;
    private Long categoryId;
    private Long subCategoryId;
    private Long equipmentId;
    private Long slaId;

    private LocalDateTime slaStartTime;
    private LocalDateTime slaEndTime;
    private LocalDateTime slaBreachTime;
    private boolean slaBreach;
}