package com.smartfarm.backend.service;

import com.smartfarm.backend.dto.AutomationRunResponseDto;
import com.smartfarm.backend.entity.ActivityLog;
import com.smartfarm.backend.entity.AutomationExecution;
import com.smartfarm.backend.repository.ActivityLogRepository;
import com.smartfarm.backend.repository.AutomationExecutionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AutomationService {

    private final AutomationExecutionRepository automationExecutionRepository;
    private final ActivityLogRepository activityLogRepository;

    public AutomationService(
            AutomationExecutionRepository automationExecutionRepository,
            ActivityLogRepository activityLogRepository
    ) {
        this.automationExecutionRepository = automationExecutionRepository;
        this.activityLogRepository = activityLogRepository;
    }

    public AutomationRunResponseDto runAutomation(String taskName) {
        String status = "SUCCESS";
        LocalDateTime now = LocalDateTime.now();

        AutomationExecution execution = new AutomationExecution(taskName, status);
        automationExecutionRepository.save(execution);

        String message = taskName + " automation request completed.";
        ActivityLog activityLog = new ActivityLog("✅ " + message, "AUTOMATION");
        activityLogRepository.save(activityLog);

        return new AutomationRunResponseDto(
                status,
                taskName,
                message,
                now
        );
    }
}