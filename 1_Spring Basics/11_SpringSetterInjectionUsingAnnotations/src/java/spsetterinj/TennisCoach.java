package spsetterinj;

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
    
    
    public TennisCoach()
    {
        System.out.println("inside default constructor");
    }
    
    @Autowired // dependency injection using annotation. Can be used on any method
    public void setFortuneService(FortuneService theFortuneService)
    {
        System.out.println("inside setFortuneService method");
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
