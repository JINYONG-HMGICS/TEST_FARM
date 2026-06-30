package com.smartfarm.backend.dto;

public record FarmStatusDto(
        String greetingName,
        String summary,
        String healthTitle,
        String healthDescription,
        String healthScore
) {
}