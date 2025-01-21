package com.m4rkovic.service_app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Incident incident;

    @Column(columnDefinition = "TEXT")
    private String content;

    private boolean isInternal;

    @ManyToOne
    private Comment parentComment;

    private LocalDateTime createdAt;

    @ManyToOne
    private User createdBy;
}