package com.example.workexperienceservice.services.impl;


import com.example.workexperienceservice.common.Converter;
import com.example.workexperienceservice.dtos.WorkExperienceDto;
import com.example.workexperienceservice.entities.WorkExperience;
import com.example.workexperienceservice.exceptions.DataAlreadyExistException;
import com.example.workexperienceservice.exceptions.ResourceNotFoundException;
import com.example.workexperienceservice.repositories.WorkExperienceRepository;
import com.example.workexperienceservice.services.WorkExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class WorkExperienceServiceImpl implements WorkExperienceService {
    private final WorkExperienceRepository repository;
    private final Converter converter;
    @Override
    public WorkExperienceDto create(WorkExperienceDto workExperienceDto) {
        Optional.ofNullable(workExperienceDto.getId()).ifPresent(id -> {
            if (repository.existsById(id)) {
                throw new DataAlreadyExistException("Work Experience with id " + id + " already exists");
            }
        });
        return converter.convert(repository.save(converter.convert(workExperienceDto, WorkExperience.class)), WorkExperienceDto.class);
    }

    @Override
    public List<WorkExperienceDto> findAll() {
        return converter.convertList(repository.findAll(), WorkExperienceDto.class);
    }

    @Override
    public WorkExperienceDto update(WorkExperienceDto workExperienceDto, Long id) {
        return Optional.ofNullable(workExperienceDto.getId()).map(entityId -> {
            if (!repository.existsById(entityId)) {
                throw new ResourceNotFoundException("Work Experience with id " + entityId + " not found");
            }
            return converter.convert(
                    repository.save(
                            converter.convert(workExperienceDto, WorkExperience.class)
                    ), WorkExperienceDto.class);
        }).orElseThrow(() -> new ResourceNotFoundException("Work Experience with id " + id + " not found"));
    }

    @Override
    public WorkExperienceDto getWorkExperienceById(Long id) {
        return Optional.ofNullable(id)
                .map(repository::findById)
                .map(workExperience -> converter.convert(workExperience, WorkExperienceDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Work Experience with id " + id + " not found"));
    }

    @Override
    public void delete(Long id) {
        Optional.ofNullable(id).ifPresent(repository::deleteById);
    }
}

