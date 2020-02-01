
package spsetinj;

/**
 *
 * @author arken
 */
public class BaseballCoach implements Coach{
    
    private FortuneService fortuneservice;
    private String email,team,yourNickname,yourCrush;

    public String getYourNickname() {
        return yourNickname;
    }

    public void setYourNickname(String yourNickname) {
        this.yourNickname = yourNickname;
    }

    public String getYourCrush() {
        return yourCrush;
    }

    public void setYourCrush(String yourCrush) {
        this.yourCrush = yourCrush;
    }
    

    public BaseballCoach()
    {
    }
    
    public void setFortuneService(FortuneService fs)
    {
        fortuneservice=fs;
    }
    
    public void setEmailAddr(String email) {
        this.email = email;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmailAddr() {
        return email;
    }

    public String getTeam() {
        return team;
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
