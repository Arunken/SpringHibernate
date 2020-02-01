/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spsetinj;

/**
 *
 * @author arken
 */
public class TrackCoach implements Coach{

    FortuneService fs;
    
    public TrackCoach()
    {
    }
    
    public void setFortuneService(FortuneService fser)
    {
        fs=fser;
    }
    
    @Override
    public String getDailyWorkout() {
        
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return fs.getFortune();
    }
    
}
