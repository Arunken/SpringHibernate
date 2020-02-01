/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spfieldinj;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SilverDoe
 */
public class MyApp {
    
    /*
    Field Injection :
    ============
    >> Configure the dependency injection with Autowired Annotation
    >> Applied directly to the field
    >> No need for setter methods
    
    */
    
    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spfieldinj/applicationcontext.xml");
        
        Coach thecoach = context.getBean("tennisCoach", Coach.class);
        
        System.out.println(thecoach.getDailyWorkout());
        System.out.println(thecoach.getDailyFortune());
        
        context.close();
    }
    
}
