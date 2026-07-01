package com.smartfarm.backend.service;

import com.smartfarm.backend.dto.ZoneDto;
import com.smartfarm.backend.dto.ZoneUpdateRequestDto;
import com.smartfarm.backend.entity.Zone;
import com.smartfarm.backend.repository.ZoneRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {

    private final ZoneRepository zoneRepository;
    private final ActivityService activityService;

    public ZoneService(
            ZoneRepository zoneRepository,
            ActivityService activityService
    ) {
        this.zoneRepository = zoneRepository;
        this.activityService = activityService;
    }

    public List<ZoneDto> getZones() {
        if (zoneRepository.count() == 0) {
            seedDefaultZones();
        }

        return zoneRepository.findAllByOrderByIdAsc()
                .stream()
                .map(this::toDto)
                .toList();
    }

    public ZoneDto updateZone(Long id, ZoneUpdateRequestDto request) {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Zone not found. id=" + id));

        zone.updateStatus(request.status(), request.description());
        Zone savedZone = zoneRepository.save(zone);

        activityService.createActivity(
                "✅ " + savedZone.getName() + " status updated to " + savedZone.getStatus(),
                "ZONE"
        );

        return toDto(savedZone);
    }

    private ZoneDto toDto(Zone zone) {
        return new ZoneDto(
                zone.getIcon(),
                zone.getName(),
                zone.getStatus(),
                zone.getDescription()
        );
    }

    private void seedDefaultZones() {
        zoneRepository.saveAll(List.of(
                new Zone("🌱", "Zone A", "Healthy", "Leafy greens / Stable"),
                new Zone("🌿", "Zone B", "Growing", "Herbs / Humidity low"),
                new Zone("🌾", "Zone C", "Harvest Ready", "Premium showcase zone")
        ));
    }
}