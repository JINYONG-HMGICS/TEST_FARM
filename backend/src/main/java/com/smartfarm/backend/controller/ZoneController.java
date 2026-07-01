package com.smartfarm.backend.controller;

import com.smartfarm.backend.dto.ZoneDto;
import com.smartfarm.backend.dto.ZoneUpdateRequestDto;
import com.smartfarm.backend.service.ZoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {

    private final ZoneService zoneService;

    public ZoneController(ZoneService zoneService) {
        this.zoneService = zoneService;
    }

    @GetMapping
    public List<ZoneDto> getZones() {
        return zoneService.getZones();
    }

    @PutMapping("/{id}")
    public ZoneDto updateZone(
            @PathVariable Long id,
            @RequestBody ZoneUpdateRequestDto request
    ) {
        return zoneService.updateZone(id, request);
    }
}