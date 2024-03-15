package com.example.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class VoleyBallCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice for voleyball 1 hour!!!";
    }
}
