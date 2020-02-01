package spconinj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author SilverDoe
 */

// adding annotation
@Component // using default bean id implicitly. Default will be the class name starting with lowercase and so in this case 'tennisCoach'
public class TennisCoach implements Coach{

    private FortuneService fortuneService;
    
    @Autowired // autowiring FortuneService type object and injecting
    public TennisCoach(FortuneService theFortuneService)
    {
        fortuneService=theFortuneService;
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
