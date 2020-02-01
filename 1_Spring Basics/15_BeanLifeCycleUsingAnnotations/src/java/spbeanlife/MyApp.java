/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spbeanlife;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SilverDoe
 */
public class MyApp {
    
    /*
        
    
    Define your methods for init and destroy :
    ==========================================
    >> init method : add @PostConstruct
    >> destroy method : @PreDestroy
    >> here we are using init and destroy methods in TennisCoach class
    
    */
    
    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spbeanlife/applicationcontext.xml");
        
        Coach thecoach = context.getBean("tennisCoach", Coach.class);
        
        System.out.println(thecoach.getDailyWorkout());
        
        context.close();
    }
    
}
