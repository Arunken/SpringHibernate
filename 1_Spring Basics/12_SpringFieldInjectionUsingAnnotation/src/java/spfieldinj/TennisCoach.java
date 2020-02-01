package spfieldinj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author SilverDoe
 */

// adding annotation
@Component // using default bean id implicitly. Default will be the class name starting with lowercase and so in this case 'tennisCoach'
public class TennisCoach implements Coach{

    @Autowired // Autowiring directly on the field instead of constructor or setter injection. Done using injection
    private FortuneService fortuneService;
    
    
    public TennisCoach()
    {
        System.out.println("inside default constructor");
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
