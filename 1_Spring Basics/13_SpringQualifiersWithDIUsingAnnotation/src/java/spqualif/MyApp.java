/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spqualif;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SilverDoe
 */
public class MyApp {
    
    /*
    Any Injection Using Qualifiers :
    ============
    >> When there are more than one implementation of an Interface then spring will be confused whether which implementation to inject.
    >> This results in a 'NoUniqueBeanDefinitionException'
    >> To solve this issue we use @Qualifier to provide the Qualified implementation to be injected
    
    
    >> can be applied on constructor, setter, field injection
    
    */
    
    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spqualif/applicationcontext.xml");
        
        Coach thecoach = context.getBean("tennisCoach", Coach.class);
        
        System.out.println(thecoach.getDailyWorkout());
        System.out.println(thecoach.getDailyFortune());
        
        context.close();
    }
    
}
