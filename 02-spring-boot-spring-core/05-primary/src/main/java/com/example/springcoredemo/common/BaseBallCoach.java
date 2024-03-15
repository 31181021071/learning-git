package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice for baseball 1 hour!!!";
    }
}
