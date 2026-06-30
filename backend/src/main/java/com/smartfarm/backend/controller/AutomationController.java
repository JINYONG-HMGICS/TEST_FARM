package com.smartfarm.backend.controller;

import com.smartfarm.backend.dto.AutomationRunResponseDto;
import com.smartfarm.backend.service.AutomationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/automation")
public class AutomationController {

    private final AutomationService automationService;

    public AutomationController(AutomationService automationService) {
        this.automationService = automationService;
    }

    @PostMapping("/run")
    public AutomationRunResponseDto runAutomation(@RequestBody Map<String, String> request) {
        String taskName = request.get("taskName");
        return automationService.runAutomation(taskName);
    }
}