package com.smartfarm.backend.dto;

import java.time.LocalDateTime;

public record ActivityLogDto(
        Long id,
        String message,
        String type,
        LocalDateTime createdAt
) {
}