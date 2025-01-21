package com.m4rkovic.service_app.dto;

import com.m4rkovic.service_app.enumerator.Criticality;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SLADTO {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
    private String name;

    private String description;

    @NotNull(message = "Response time is required")
    @Min(value = 1, message = "Response time must be positive")
    private Integer responseTimeMinutes;

    @NotNull(message = "Resolution time is required")
    @Min(value = 1, message = "Resolution time must be positive")
    private Integer resolutionTimeMinutes;

    @NotNull(message = "Group ID is required")
    private Long applicableGroupId;

    @NotNull(message = "Criticality is required")
    private Criticality criticality;

    private boolean businessHoursOnly;
    private String workingDays;
    private String workingHours;
    private boolean active = true;
}