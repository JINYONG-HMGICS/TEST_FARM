package com.smartfarm.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "sensor_reading")
public class SensorReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zoneName;

    private Double temperature;

    private Double humidity;

    private Integer light;

    private String growthStatus;

    private LocalDateTime measuredAt;

    protected SensorReading() {
    }

    public SensorReading(
            String zoneName,
            Double temperature,
            Double humidity,
            Integer light,
            String growthStatus
    ) {
        this.zoneName = zoneName;
        this.temperature = temperature;
        this.humidity = humidity;
        this.light = light;
        this.growthStatus = growthStatus;
        this.measuredAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getZoneName() {
        return zoneName;
    }

    public Double getTemperature() {
        return temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Integer getLight() {
        return light;
    }

    public String getGrowthStatus() {
        return growthStatus;
    }

    public LocalDateTime getMeasuredAt() {
        return measuredAt;
    }
}