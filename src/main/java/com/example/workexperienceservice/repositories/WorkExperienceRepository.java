package com.example.workexperienceservice.repositories;

import com.example.workexperienceservice.entities.WorkExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {
    void deleteByUserId(Long userId);
}
