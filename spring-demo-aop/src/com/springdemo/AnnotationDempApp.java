package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDempApp {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from Spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);

        // call method on the Bean
        System.out.println(coach.getDailyWorkOut());
        // call method get dailyFortune - is @Autowire gauta
        System.out.println(coach.getDailyFortune());

        // close the Context
        context.close();
    }

}
