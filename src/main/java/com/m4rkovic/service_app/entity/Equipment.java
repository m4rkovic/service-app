package com.m4rkovic.service_app.entity;

import com.m4rkovic.service_app.enumerator.EquipmentStatus;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "equipment")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serialNumber;
    private String model;
    private String manufacturer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private EquipmentCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_to_id")
    private User assignedTo;

    private LocalDateTime assignmentDate;
    private LocalDateTime returnDueDate;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status;

    @ElementCollection
    @CollectionTable(name = "equipment_specifications",
            joinColumns = @JoinColumn(name = "equipment_id"))
    @MapKeyColumn(name = "spec_key")
    @Column(name = "spec_value")
    private Map<String, String> specifications;

    private String notes;
    private boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private User createdBy;
}