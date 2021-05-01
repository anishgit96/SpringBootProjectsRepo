package com.example.ScheduleApiHit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Scheduled(fixedRate = 5000)
    @GetMapping(value="/hello")
    public void greeting() {
      System.out.println("Hello GIIT Sol From Anish");
    }
}
