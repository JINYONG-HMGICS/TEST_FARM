package com.smartfarm.backend.repository;

import com.smartfarm.backend.entity.AutomationExecution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomationExecutionRepository extends JpaRepository<AutomationExecution, Long> {
}