package com.m4rkovic.service_app.entity;

import com.m4rkovic.service_app.enumerator.Criticality;
import com.m4rkovic.service_app.enumerator.Status;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Incident {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketNumber;
    private String title;
    private String description;
    private Criticality criticality;
    private Status status;

    @ManyToOne
    private User reportedBy;

    @ManyToOne
    private User assignedTo;

    @ManyToOne
    private Group assignedGroup;

    @ManyToOne
    private Category category;

    @ManyToOne
    private SubCategory subCategory;

    @ManyToOne
    private Equipment relatedEquipment;

    // SLA fields
    private LocalDateTime slaStartTime;
    private LocalDateTime slaEndTime;
    private LocalDateTime slaBreachTime;
    private boolean slaBreach;

    @ManyToOne
    private SLA appliedSLA;

    @OneToMany(mappedBy = "incident")
    private List<WorkLog> workLogs;

    @OneToMany(mappedBy = "incident")
    private List<Comment> comments;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime resolvedAt;

    @ManyToOne
    private User createdBy;

    @ManyToOne
    private User updatedBy;
}