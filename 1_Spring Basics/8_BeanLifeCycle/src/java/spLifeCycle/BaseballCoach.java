
package spLifeCycle;

import org.springframework.stereotype.Component;

/**
 *
 * @author arken
 */

public class BaseballCoach implements Coach{
    
    private FortuneService fortuneservice;
    private String email,team;

    public BaseballCoach()
    {
    } 
    
    public void setFortuneService(FortuneService fs)
    {
        fortuneservice=fs;
    }
        
    @Override
    public String getDailyWorkout()
    {
        return "Spend 30 min on batting practice";
    }

    @Override
    public String getDailyFortune() {
        
        return fortuneservice.getFortune();
    }
    
    // add an init method
    public void startupStuff()
    {
        System.out.println("initializing my init method");
    }
    
    // add a destroy method
    public void shutdownStuff()
    {
        System.out.println("cleanup under process");
    }
    
    
    
}
