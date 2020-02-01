package spconfigjav;

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
    
}
