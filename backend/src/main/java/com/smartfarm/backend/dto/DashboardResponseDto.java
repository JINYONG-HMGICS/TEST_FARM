package com.smartfarm.backend.dto;

import java.util.List;

public record DashboardResponseDto(
        FarmStatusDto farmStatus,
        List<MetricDto> metrics,
        List<ZoneDto> zones,
        List<AutomationTaskDto> automationTasks,
        List<String> activities
) {
}