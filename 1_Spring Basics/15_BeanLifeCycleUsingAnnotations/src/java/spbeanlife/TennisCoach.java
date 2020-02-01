package spbeanlife;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 *
 * @author SilverDoe
 */


@Component // using default bean id implicitly. Default will be the class name starting with lowercase and so in this case 'tennisCoach'
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
    
    // add an init method
    @PostConstruct // init annotation
    public void startupStuff()
    {
        System.out.println("initializing my init method");
    }
    
    // add a destroy method
    @PreDestroy // destroy annotation
    public void shutdownStuff()
    {
        System.out.println("cleanup under process");
    }
    
}
