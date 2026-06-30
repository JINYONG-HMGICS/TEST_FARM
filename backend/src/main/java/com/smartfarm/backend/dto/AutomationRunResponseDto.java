package com.smartfarm.backend.dto;

import java.time.LocalDateTime;

public record AutomationRunResponseDto(
        String status,
        String taskName,
        String message,
        LocalDateTime timestamp
) {
}