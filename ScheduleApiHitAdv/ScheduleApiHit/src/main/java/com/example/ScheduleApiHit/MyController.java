package com.example.ScheduleApiHit;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	private EmployeeRepository repository;

    @Scheduled(fixedRate = 5000)
    @GetMapping(value="/hello")
    public void greeting() {
      
    }
    
    @GetMapping("/employees")
    List<Employee> all() {
      return repository.findAll();
    }
    
    @Scheduled(fixedRate = 60000)
    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
      return repository.save(newEmployee);
    }
}
