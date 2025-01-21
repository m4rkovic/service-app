package com.m4rkovic.service_app.entity;

import com.m4rkovic.service_app.enumerator.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //    public class User extends AuditableEntity {
    @Id
    private Long id;

    // Basic Info
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String phone;

    // Professional Info
    private String title;
    private String function;
    @ManyToOne
    private Company company;
    private String department;
    // Location Info
    private String building;
    @ManyToOne
    private Location location;   // specific location/office

    // Organizational Info
    @ManyToOne
    private User supervisor;
    @ManyToOne
    private Company employer;

    // System Info
    private String language;
    private LocalDateTime lastLogin;
    private String details;

    // Access Control
    @Enumerated(EnumType.STRING)
    private UserRole role;
    private boolean active;

    // Relationships
    @ManyToMany(mappedBy = "members")
    private Set<Group> groups;

    @OneToMany(mappedBy = "assignedTo")
    private Set<Equipment> assignedEquipment;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    // Audit fields (inherited from AuditableEntity)
    // - createdAt
    // - updatedAt
    // - createdBy
    // - lastModifiedBy
}
