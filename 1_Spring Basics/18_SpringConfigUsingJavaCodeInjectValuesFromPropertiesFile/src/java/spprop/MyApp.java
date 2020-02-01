/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spprop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SilverDoe
 */
public class MyApp {
    
    /*
    
    Inject Values from Properties :
    ====================================
    1. Create properties file
    2. Load properties file in spring config using 
    3. Reference values from properties file
    
    */
    
    public static void main(String[] args) {
        
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        
        TennisCoach thecoach = context.getBean("tennisCoach", TennisCoach.class);
        
        System.out.println(thecoach.getDailyWorkout());
        System.out.println(thecoach.getDailyFortune());
        
        System.out.println(thecoach.getEmail());
        System.out.println(thecoach.getTeam());
        
        context.close();
    }
    
}
