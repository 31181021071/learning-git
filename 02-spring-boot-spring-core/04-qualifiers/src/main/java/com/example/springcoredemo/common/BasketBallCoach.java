package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice for basketball 1 hour!!!";
    }
}
