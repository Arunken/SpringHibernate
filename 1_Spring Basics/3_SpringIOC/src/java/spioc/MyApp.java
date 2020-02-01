/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author arken
 */
public class MyApp {
    
    /*
    IOC can be established using configuration of spring container in the following ways :
    1. Full XML config(uses only XML config file for configuring spring container)
    2. Component Scanning of Annotations(uses XML config file for component scanning)
    3. Configuration using full java code(no XML file needed)
    */
    
    public static void main(String[] args) {
        
        // load the spring config file from classpath or create a spring container
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("spioc/applicationcontext.xml");
        
        // if the file is located in web dir
        //ApplicationContext context1 =new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        
        //retrieve bean from spring container
        Coach thecoach = context.getBean("mycoach",Coach.class);
        
        //call methods on bean
        System.out.println(thecoach.getDailyWorkout());
        
        //close the context
        context.close();
    }
    
}
