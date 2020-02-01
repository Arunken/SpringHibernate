/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spbeanscopePrototype;

import spbeanscopeSingleton.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author arken
 */
public class MyApp {
    
    public static void main(String[] args) {
        
        //load spring config file    
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("spbeanscopePrototype/applicationcontext.xml");
        
        //retrieving bean from spring container 
        
        Coach thecoach = context.getBean("mycoach",Coach.class);
        
        Coach thecoach1 = context.getBean("mycoach",Coach.class);
        
        //both these objects will be different...scope is prototype
        
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
        
        

        context.close();
    }
    
}
