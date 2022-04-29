package com.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {
    // expose "/" that return "Hello world"
    @GetMapping("/")
    public String sayHello(){
        return "Hello world!  Time on server is " + LocalDateTime.now();
    }

    // expose a new endpoint for ""workout""
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run hard 5 k";
    }
    @GetMapping("/fortune")
    public String fortune() {
        return "Today is your lucky day";
    }

}
