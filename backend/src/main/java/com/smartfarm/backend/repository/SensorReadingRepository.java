package com.smartfarm.backend.repository;

import com.smartfarm.backend.entity.SensorReading;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SensorReadingRepository extends JpaRepository<SensorReading, Long> {

    Optional<SensorReading> findTopByOrderByMeasuredAtDesc();
}