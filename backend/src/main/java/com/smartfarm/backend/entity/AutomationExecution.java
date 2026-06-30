package com.smartfarm.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "automation_execution")
public class AutomationExecution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String taskName;

    private String status;

    private LocalDateTime requestedAt;

    private LocalDateTime completedAt;

    protected AutomationExecution() {
    }

    public AutomationExecution(String taskName, String status) {
        this.taskName = taskName;
        this.status = status;
        this.requestedAt = LocalDateTime.now();
        this.completedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getRequestedAt() {
        return requestedAt;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }
}