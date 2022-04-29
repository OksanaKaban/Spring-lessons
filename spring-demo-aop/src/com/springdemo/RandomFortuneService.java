package com.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    // create an array of strings
    private String [] data = {
          "kruopstumas yra kelias i sekme",
            "kelione yra atlygis",
            "miegas raktas i sekme"
    };
    // create random number generator
    private Random random = new Random();

    @Override
    public String getFortune() {
        // pick random String from array
        int index = random.nextInt(data.length);
        String fortune = data[index];
        return fortune;
    }
}
