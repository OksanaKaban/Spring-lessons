package com.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from Spring container
        Coach coach = context.getBean("tennisCoach", Coach.class);
        Coach coach1 = context.getBean("tennisCoach", Coach.class);

        // palyginsime, ar bean'ai yra tie patys
        boolean result = (coach == coach1);

        // atspausdinti rezultatus
        System.out.println("Rodome i ta pati objekta: " + result);
        System.out.println("memory location for coach: " + coach);
        System.out.println("memory location for coach1: " + coach1);

        // call method on the Bean
//        System.out.println(coach.getDailyWorkOut());
        // call method get dailyFortune - is @Autowire gauta
//        System.out.println(coach.getDailyFortune());

        // close the Context
        context.close();
    }
}
