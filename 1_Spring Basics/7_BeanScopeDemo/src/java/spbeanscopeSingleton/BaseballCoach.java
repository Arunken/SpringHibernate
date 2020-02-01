
package spbeanscopeSingleton;

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
    
}
