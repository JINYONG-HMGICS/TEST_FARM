package com.smartfarm.backend.service;

import com.smartfarm.backend.dto.AutomationTaskDto;
import com.smartfarm.backend.dto.DashboardResponseDto;
import com.smartfarm.backend.dto.FarmStatusDto;
import com.smartfarm.backend.dto.MetricDto;
import com.smartfarm.backend.entity.SensorReading;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    private final ActivityService activityService;
    private final SensorService sensorService;
    private final ZoneService zoneService;

    public DashboardService(
            ActivityService activityService,
            SensorService sensorService,
            ZoneService zoneService
    ) {
        this.activityService = activityService;
        this.sensorService = sensorService;
        this.zoneService = zoneService;
    }

    public DashboardResponseDto getDashboard() {
        SensorReading latestSensor = sensorService.getLatestSensorReading();

        return new DashboardResponseDto(
                new FarmStatusDto(
                        "Jinyong",
                        "Everything is operating normally across the smart farm.",
                        "Healthy & Ready for Customer Experience",
                        "All growing zones are stable.",
                        "96%"
                ),
                List.of(
                        new MetricDto("🌡", "Temperature", latestSensor.getTemperature() + "°C"),
                        new MetricDto("💧", "Humidity", latestSensor.getHumidity().intValue() + "%"),
                        new MetricDto("☀️", "Light", latestSensor.getLight() + " lux"),
                        new MetricDto("🌿", "Growth", latestSensor.getGrowthStatus())
                ),
                zoneService.getZones(),
                List.of(
                        new AutomationTaskDto("💧", "Irrigation", "Run short watering cycle"),
                        new AutomationTaskDto("☀️", "LED Lighting", "Adjust light intensity for demo"),
                        new AutomationTaskDto("🌬", "Ventilation", "Refresh airflow in growing zones")
                ),
                activityService.getRecentActivities()
                        .stream()
                        .map(activity -> activity.message())
                        .toList()
        );
    }
}