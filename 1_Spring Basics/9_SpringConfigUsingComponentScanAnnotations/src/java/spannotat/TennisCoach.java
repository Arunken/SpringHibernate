package spannotat;

import org.springframework.stereotype.Component;

/**
 *
 * @author SilverDoe
 */

// adding annotation // explicitly giving bean id
@Component("mycoach") // spring will automatically register this bean with bean 'mycoach' as component scanning is enabled for the package in applicationcontext
//or
//@Component // using default bean id implicitly. Default will be the class name starting with lowercase and so in this case 'tennisCoach'
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
    
}
