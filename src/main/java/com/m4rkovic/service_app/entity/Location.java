package com.m4rkovic.service_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "location")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String building;
    private String floor;
    private String room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_location_id")
    private Location parentLocation;

    @OneToMany(mappedBy = "parentLocation")
    private Set<Location> subLocations;

    @OneToMany(mappedBy = "location")
    private Set<User> users;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}