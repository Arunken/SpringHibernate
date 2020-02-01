/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spLifeCycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author arken
 */
public class MyApp {
    
/*
    Bean LifeCycle :
    ====================
    1. Container started
    2.Bean instantiated
    3. Dependencies injected
    4. Internal spring processing
    5. My Custom init method <<<
    6. Now bean is ready for use  to the user. The container shuts down
    7. My Custom Destroy method <<<
    
    */
    
    public static void main(String[] args) {
        
        //load spring config file    
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("spLifeCycle/applicationcontext.xml");
        
        //retrieving bean from spring container 
        
        Coach thecoach = context.getBean("mycoach",Coach.class);
        
        System.out.println(thecoach.getDailyWorkout());
        System.out.println(thecoach.getDailyFortune());
        
        context.close();
    }
    
}
