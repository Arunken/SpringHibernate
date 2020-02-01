/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdi;

/**
 *
 * @author arken
 */
public class BaseballCoach implements Coach{
    
    private FortuneService fortuneService;
    
    public BaseballCoach(FortuneService fs)
    {
        fortuneService = fs;
    }
    
    @Override
    public String getDailyWorkout()
    {
        return "Spend 30 min on batting practice";
    }

    @Override
    public String getDailyFortune() {
        
        return fortuneService.getFortune();
    }
    
}
