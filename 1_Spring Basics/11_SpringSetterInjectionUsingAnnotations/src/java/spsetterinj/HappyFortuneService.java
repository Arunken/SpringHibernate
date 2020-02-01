/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spsetterinj;

import org.springframework.stereotype.Component;

/**
 *
 * @author SilverDoe
 */

@Component // Register this class
public class HappyFortuneService implements FortuneService{

    @Override
    public String getFortune() {
        return "today is your lucky day";
    }
    
    
    
}
