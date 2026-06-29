package com.smartfarm.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class DashboardController {

    @GetMapping("/api/dashboard")
    public Map<String, Object> getDashboard() {
        return Map.of(
            "farmStatus", Map.of(
                "greetingName", "Jinyong",
                "summary", "Everything is operating normally across the smart farm.",
                "healthTitle", "Healthy & Ready for Customer Experience",
                "healthDescription", "All growing zones are stable.",
                "healthScore", "96%"
            ),
            "metrics", List.of(
                Map.of("icon", "🌡", "title", "Temperature", "value", "24.8°C"),
                Map.of("icon", "💧", "title", "Humidity", "value", "61%"),
                Map.of("icon", "☀️", "title", "Light", "value", "850 lux"),
                Map.of("icon", "🌿", "title", "Growth", "value", "Excellent")
            ),
            "zones", List.of(
                Map.of("icon", "🌱", "name", "Zone A", "status", "Healthy", "description", "Leafy greens / Stable"),
                Map.of("icon", "🌿", "name", "Zone B", "status", "Growing", "description", "Herbs / Humidity low"),
                Map.of("icon", "🌾", "name", "Zone C", "status", "Harvest Ready", "description", "Premium showcase zone")
            ),
            "automationTasks", List.of(
                Map.of("icon", "💧", "name", "Irrigation", "description", "Run short watering cycle"),
                Map.of("icon", "☀️", "name", "LED Lighting", "description", "Adjust light intensity for demo"),
                Map.of("icon", "🌬", "name", "Ventilation", "description", "Refresh airflow in growing zones")
            ),
            "activities", List.of(
                "✅ Irrigation completed in Zone A",
                "✅ Customer demo mode started",
                "⚠️ Zone B humidity slightly low",
                "✅ LED intensity adjusted"
            )
        );
    }
}