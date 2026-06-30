package com.smartfarm.backend.service;

import com.smartfarm.backend.dto.AutomationTaskDto;
import com.smartfarm.backend.dto.DashboardResponseDto;
import com.smartfarm.backend.dto.FarmStatusDto;
import com.smartfarm.backend.dto.MetricDto;
import com.smartfarm.backend.dto.ZoneDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DashboardService {

    public DashboardResponseDto getDashboard() {
        return new DashboardResponseDto(
                new FarmStatusDto(
                        "Jinyong",
                        "Everything is operating normally across the smart farm.",
                        "Healthy & Ready for Customer Experience",
                        "All growing zones are stable.",
                        "96%"
                ),
                List.of(
                        new MetricDto("🌡", "Temperature", "24.8°C"),
                        new MetricDto("💧", "Humidity", "61%"),
                        new MetricDto("☀️", "Light", "850 lux"),
                        new MetricDto("🌿", "Growth", "Excellent")
                ),
                List.of(
                        new ZoneDto("🌱", "Zone A", "Healthy", "Leafy greens / Stable"),
                        new ZoneDto("🌿", "Zone B", "Growing", "Herbs / Humidity low"),
                        new ZoneDto("🌾", "Zone C", "Harvest Ready", "Premium showcase zone")
                ),
                List.of(
                        new AutomationTaskDto("💧", "Irrigation", "Run short watering cycle"),
                        new AutomationTaskDto("☀️", "LED Lighting", "Adjust light intensity for demo"),
                        new AutomationTaskDto("🌬", "Ventilation", "Refresh airflow in growing zones")
                ),
                List.of(
                        "✅ Irrigation completed in Zone A",
                        "✅ Customer demo mode started",
                        "⚠️ Zone B humidity slightly low",
                        "✅ LED intensity adjusted"
                )
        );
    }
}