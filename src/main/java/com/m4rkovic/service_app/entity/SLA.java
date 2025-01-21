package com.m4rkovic.service_app.entity;

import com.m4rkovic.service_app.enumerator.Criticality;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "sla")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SLA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    private Integer responseTimeMinutes;
    private Integer resolutionTimeMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group applicableGroup;

    @Enumerated(EnumType.STRING)
    private Criticality criticality;

    private boolean businessHoursOnly;
    private String workingDays;
    private String workingHours;
    private boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private User createdBy;
}