package com.example.workexperienceservice.services;


import com.example.workexperienceservice.dtos.WorkExperienceDto;

import java.util.List;

public interface WorkExperienceService {
    WorkExperienceDto create(WorkExperienceDto workExperienceDto);

    List<WorkExperienceDto> findAll();

    WorkExperienceDto update(WorkExperienceDto workExperienceDto, Long id);

    WorkExperienceDto getWorkExperienceById(Long id);

    void delete(Long id);
}
