/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spconfigjav;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SilverDoe
 */
public class MyApp {
    
    /*
    
    Spring config with java config class(no XML needed) using component scanning :
    ====================================
    1. Create a java class and annotate as @Configuration
    2. Add component scanning support @ComponentScan(optional)
    3. Read Spring Java config clas
    4. Retrieve bean from Spring Container
    
    
    >> AnnotationConfigApplicationContext is used to read spring config from java class
    */
    
    public static void main(String[] args) {
        
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        
        Coach thecoach = context.getBean("tennisCoach", Coach.class);
        
        System.out.println(thecoach.getDailyWorkout());
        
        context.close();
    }
    
}
