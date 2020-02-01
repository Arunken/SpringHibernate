/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spqualif;

import org.springframework.stereotype.Component;

/**
 *
 * @author SilverDoe
 */

@Component
public class SadFortuneService implements FortuneService{

    @Override
    public String getFortune() {
         return "today is a very bad day";
    }
    
}
