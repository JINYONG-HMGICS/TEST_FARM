package com.smartfarm.backend.dto;

public record SensorReadingRequestDto(
        String zoneName,
        Double temperature,
        Double humidity,
        Integer light,
        String growthStatus
) {
}