package com.smartfarm.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class FarmController {

    @GetMapping("/api/farm/status")
    public Map<String, Object> getFarmStatus() {

        return Map.of(
                "temperature", "24.8°C",
                "humidity", "61%",
                "light", "850 lux",
                "growth", "Excellent"
        );

    }

}