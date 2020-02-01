/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgioc;

/**
 *
 * @author arken
 */
public class SpiritMotivationService implements  MotivationService{

    @Override
    public String getmotivation() {
        return "free spirit motivation";
    }
    
}
