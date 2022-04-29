package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.springdemo") // uzkomentuota, nes naudojam dabar @Bean
@PropertySource(value = "classpath:/aplication.yaml", encoding = "UTF-8") // cia kad LT raides
//@PropertySource(value = "classpath:/sport.properties")
public class SportConfig {
    // define bean for our SadFortuneService
    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortuneService();
    }

    // define bean for our SwimCoach and inject dependency
    @Bean
    public Coach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }



}
