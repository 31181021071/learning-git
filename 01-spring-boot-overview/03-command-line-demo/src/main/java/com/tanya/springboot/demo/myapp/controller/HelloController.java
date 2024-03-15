package com.tanya.springboot.demo.myapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Value("${coach.name}")
    private String name;
    @GetMapping("/")
    public String sayHello() {
        return "Hello " + name + "!!!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Runnnnn";
    }
    @GetMapping("/resting")
    public String restingAfterWorkout() {
        return "Resting";
    }


}
