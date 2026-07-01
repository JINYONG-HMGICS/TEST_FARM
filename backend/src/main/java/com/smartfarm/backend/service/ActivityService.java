package com.smartfarm.backend.service;

import com.smartfarm.backend.dto.ActivityLogDto;
import com.smartfarm.backend.entity.ActivityLog;
import com.smartfarm.backend.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final ActivityLogRepository activityLogRepository;

    public ActivityService(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    public List<ActivityLogDto> getRecentActivities() {
        return activityLogRepository.findTop10ByOrderByCreatedAtDesc()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public ActivityLogDto createActivity(String message, String type) {
        ActivityLog activityLog = new ActivityLog(message, type);
        ActivityLog savedActivityLog = activityLogRepository.save(activityLog);

        return toDto(savedActivityLog);
    }

    private ActivityLogDto toDto(ActivityLog activityLog) {
        return new ActivityLogDto(
                activityLog.getId(),
                activityLog.getMessage(),
                activityLog.getType(),
                activityLog.getCreatedAt()
        );
    }
}