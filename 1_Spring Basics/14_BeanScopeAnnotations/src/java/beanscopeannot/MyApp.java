/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beanscopeannot;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author SilverDoe
 */
public class MyApp {
    
    /*
    Bean Scope using Annotations :
    ============
    >> Use @Scope("scopename") over the classes 
    >> By default the scope is singleton
    >> Here the class TennisCoach is given a prototype scope
    
    */
    
    public static void main(String[] args) {
        
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanscopeannot/applicationcontext.xml");
        
        Coach thecoach = context.getBean("tennisCoach", Coach.class);
        
        Coach thecoach1 = context.getBean("tennisCoach", Coach.class);
        
        if(thecoach==thecoach1)
        {
            System.out.println("same object");
            System.out.println("memory location 1 : "+thecoach);
            System.out.println("memory location 2 : "+thecoach1);
        }
        else
        {
            System.out.println("different object");
            System.out.println("memory location 1 : "+thecoach);
            System.out.println("memory location 2 : "+thecoach1);
        }
    }
    
}
