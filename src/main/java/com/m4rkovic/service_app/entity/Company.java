package com.m4rkovic.service_app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "company")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String registrationNumber;
    private String taxNumber;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String phone;
    private String email;
    private String website;

    private boolean active;
    private String notes;

    @OneToMany(mappedBy = "company")
    private Set<User> employees;

    @OneToMany(mappedBy = "employer")
    private Set<User> contractedEmployees;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}