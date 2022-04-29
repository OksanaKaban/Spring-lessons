package com.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component // bean ID buvo (buvo kaip "sillyCoach")
@Scope("singleton") // singleton - default
//@Scope ("prototype") // arba - neveikia PreDestroy
public class TennisCoach implements Coach {

    @Autowired
    // cia paskutinis budas per argumenta - laukeli "randomFortune..."- FortuneService naudojant Java technol.Reflection
//    @Qualifier("happyFortuneService")
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService; // objektas keiciamas tiesiogiai, nereikia konstruktoriu, seteriu

    //    @Autowired
//    public TennisCoach(FortuneService fortuneService) { // per construction injection 1as budas default
//        this.fortuneService = fortuneService;
//    }
    @Override
    public String getDailyWorkOut() {
        return "Practice your hand skills";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public TennisCoach() {
        System.out.println("TennisCoach: inside default constructor ");
    }

//    @Autowired    // Autowire - perduodame objekto priklausomybes
//    public void setFortuneService(FortuneService fortuneService){ // cia per setteri 2as budas
//        this.fortuneService = fortuneService;
//        System.out.println("TennisCoach: inside setFortuneService");
//    }

//    @Autowired
//    public void doSomeCrazyStuff(FortuneService fortuneService) { // siuo pvz ziuresime kai per konstruktoriu is metodo perduosim
//        System.out.println("TennisCoach: inside doSomeCrazyStuff method " );
//        this.fortuneService = fortuneService;
//    }

    // define my init. method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("TennisCoach: inside doMyStartupStuff");
    }

    // define my destroy method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("TennisCoach: inside doMyCleanupStuff");
    }

}
