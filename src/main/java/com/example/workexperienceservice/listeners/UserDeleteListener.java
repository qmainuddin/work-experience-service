package com.example.workexperienceservice.listeners;

import com.example.workexperienceservice.services.WorkExperienceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class UserDeleteListener {
    private final WorkExperienceService service;
    public void onMessageReceived(String message) {
        System.out.println("Received from work experience listener [" + message + "]");
        service.deleteByUserId(Long.parseLong(message));
        System.out.println("Work experiences related to the user: " + message + " are deleted.");
    }
}
