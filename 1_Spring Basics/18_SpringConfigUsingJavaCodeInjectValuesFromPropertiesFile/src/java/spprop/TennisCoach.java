package spprop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 *
 * @author SilverDoe
 */



public class TennisCoach implements Coach{

    private FortuneService fortuneService;
    
    @Value("${email}")// reference values from properties file
    private String email;
    
    @Value("${team}")
    private String team;

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
    
    public TennisCoach(FortuneService theFortuneService)
    {
        fortuneService = theFortuneService;
    }
    
    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    
}
