package com.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {
    public static void main(String[] args) {

        // read spring config Java class SportConfig
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        // get the bean from Spring container
//        Coach coach = context.getBean("swimCoach", Coach.class);
        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

        // call method on the Bean
        System.out.println(coach.getDailyWorkOut());

        // call method get dailyFortune - is @Autowire gauta
        System.out.println(coach.getDailyFortune());

//  call our new SwimCoach methods, has the props values injected
        System.out.println("email: " + coach.getEmail() + "\nteam: " + coach.getTeam());

        // close the Context
        context.close();
    }
}
