package com.m4rkovic.service_app.entity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "equipment_category")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ElementCollection
    @CollectionTable(name = "equipment_category_fields",
            joinColumns = @JoinColumn(name = "category_id"))
    @Column(name = "field_name")
    private List<String> specificFields;

    private boolean active;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "category")
    private Set<Equipment> equipments;
}