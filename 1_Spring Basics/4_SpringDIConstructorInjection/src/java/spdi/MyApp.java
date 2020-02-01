/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spdi;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author arken
 */
public class MyApp {
    
    public static void main(String[] args) {
        
        //load spring config file
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("spdi/applicationcontext.xml");
        
        //retrieve beans
        Coach thecoach = context.getBean("mycoach",Coach.class);
        

        System.out.println(thecoach.getDailyWorkout());
        
        //let's call our new method for fortunes
        System.out.println(thecoach.getDailyFortune());

        context.close();
    }
    
}
