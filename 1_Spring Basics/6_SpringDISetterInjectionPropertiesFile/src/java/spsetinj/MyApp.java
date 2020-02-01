/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spsetinj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author arken
 */
public class MyApp {
    
    public static void main(String[] args) {
        
        //load spring config file    
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("spsetinj/applicationcontext.xml");
        
        //retrieving bean from spring container 
        //calling def constructor and then setter injection configured in the applicationcontext.xml
        BaseballCoach thecoach = context.getBean("mycoach",BaseballCoach.class);
        

        System.out.println(thecoach.getDailyWorkout());
        
        //let's call our new method for fortunes
        System.out.println(thecoach.getDailyFortune());
        
        // get the literal values
        System.out.println(thecoach.getEmailAddr()+"\n"+thecoach.getTeam());
        System.out.println(thecoach.getYourNickname()+"\n"+thecoach.getYourCrush());

        context.close();
    }
    
}
