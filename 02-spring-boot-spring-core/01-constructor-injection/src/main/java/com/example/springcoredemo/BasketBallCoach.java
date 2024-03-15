package com.example.springcoredemo;

import org.springframework.stereotype.Component;

@Component
public class BasketBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice for 1 hour!!!";
    }
}
