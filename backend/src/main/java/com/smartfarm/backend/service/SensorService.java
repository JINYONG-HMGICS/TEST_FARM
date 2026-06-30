package com.smartfarm.backend.service;

import com.smartfarm.backend.dto.SensorReadingRequestDto;
import com.smartfarm.backend.entity.SensorReading;
import com.smartfarm.backend.repository.SensorReadingRepository;
import org.springframework.stereotype.Service;

@Service
public class SensorService {

    private final SensorReadingRepository sensorReadingRepository;

    public SensorService(SensorReadingRepository sensorReadingRepository) {
        this.sensorReadingRepository = sensorReadingRepository;
    }

    public SensorReading getLatestSensorReading() {
        return sensorReadingRepository.findTopByOrderByMeasuredAtDesc()
                .orElseGet(this::createDefaultSensorReading);
    }

    public SensorReading saveSensorReading(SensorReadingRequestDto request) {
        SensorReading reading = new SensorReading(
                request.zoneName(),
                request.temperature(),
                request.humidity(),
                request.light(),
                request.growthStatus()
        );

        return sensorReadingRepository.save(reading);
    }

    private SensorReading createDefaultSensorReading() {
        SensorReading defaultReading = new SensorReading(
                "Zone A",
                24.8,
                61.0,
                850,
                "Excellent"
        );

        return sensorReadingRepository.save(defaultReading);
    }
}