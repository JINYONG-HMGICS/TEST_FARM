package com.smartfarm.backend.controller;

import com.smartfarm.backend.dto.DashboardResponseDto;
import com.smartfarm.backend.service.DashboardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/api/dashboard")
    public DashboardResponseDto getDashboard() {
        return dashboardService.getDashboard();
    }
}