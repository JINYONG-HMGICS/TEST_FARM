package com.smartfarm.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_log")
public class ActivityLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String type;

    private LocalDateTime createdAt;

    protected ActivityLog() {
    }

    public ActivityLog(String message, String type) {
        this.message = message;
        this.type = type;
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}