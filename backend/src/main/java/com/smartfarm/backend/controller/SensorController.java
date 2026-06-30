package com.smartfarm.backend.controller;

import com.smartfarm.backend.dto.SensorReadingRequestDto;
import com.smartfarm.backend.entity.SensorReading;
import com.smartfarm.backend.service.SensorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PostMapping("/readings")
    public SensorReading createSensorReading(@RequestBody SensorReadingRequestDto request) {
        return sensorService.saveSensorReading(request);
    }

    @GetMapping("/latest")
    public SensorReading getLatestSensorReading() {
        return sensorService.getLatestSensorReading();
    }
}