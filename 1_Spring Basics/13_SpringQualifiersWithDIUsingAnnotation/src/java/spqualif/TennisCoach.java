package spqualif;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author SilverDoe
 */

// adding annotation
@Component // using default bean id implicitly. Default will be the class name starting with lowercase and so in this case 'tennisCoach'
public class TennisCoach implements Coach{

    @Autowired // Autowiring directly on the field instead of constructor or setter injection. Done using injection
    @Qualifier("sadFortuneService") // adding a qualifier to confusion of on which implementation of FortuneService to inject when there are more than one.
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
