package com.smartfarm.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "farm_zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String icon;

    private String name;

    private String status;

    private String description;

    protected Zone() {
    }

    public Zone(String icon, String name, String status, String description) {
        this.icon = icon;
        this.name = name;
        this.status = status;
        this.description = description;
    }

    public void updateStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}