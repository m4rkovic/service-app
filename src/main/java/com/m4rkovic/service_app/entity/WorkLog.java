package com.m4rkovic.service_app.entity;

import com.m4rkovic.service_app.enumerator.WorkLogType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Table(name = "work_log")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class WorkLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incident_id")
    private Incident incident;

    @Column(columnDefinition = "TEXT")
    private String description;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer timeSpentMinutes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id")
    private User worker;

    @Enumerated(EnumType.STRING)
    private WorkLogType type;

    private boolean billable;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private User createdBy;
}