package com.smartfarm.backend.controller;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/automation")
public class AutomationController {

    @PostMapping("/run")
    public Map<String, Object> runAutomation(@RequestBody Map<String, String> request) {
        String taskName = request.get("taskName");

        return Map.of(
                "status", "SUCCESS",
                "taskName", taskName,
                "message", taskName + " automation request completed.",
                "timestamp", LocalDateTime.now().toString()
        );
    }
}