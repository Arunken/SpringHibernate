/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spsetterinj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SilverDoe
 */
public class MyApp {
    
    /*
    Autowiring :
    ============
    >> For DI spring can use autowiring.
    >> Spring will look for a class that matches the property. matches by type : class or interface.
    >> Spring will inject it automatically.
    
    
    
    */
    
    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spsetterinj/applicationcontext.xml");
        
        Coach thecoach = context.getBean("tennisCoach", Coach.class);
        
        System.out.println(thecoach.getDailyWorkout());
        System.out.println(thecoach.getDailyFortune());
        
        context.close();
    }
    
}
