/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spannotat;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SilverDoe
 */
public class MyApp {
    
    /*
        >>java annotations are metadata about a class
    
    Spring config with with annotations :
    ====================================
    1. Enable component scanning in spring config file
    2. Add the @Component annotation to your java classes
    3. Retrieve bean from Spring container
    
    */
    
    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spannotat/applicationcontext.xml");
        
        Coach thecoach = context.getBean("mycoach", Coach.class);
        
        System.out.println(thecoach.getDailyWorkout());
        
        context.close();
    }
    
}
