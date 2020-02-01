/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author arken
 */
public class MainApp {
    
    public static void main(String[] args) {
        
        // using FileSystemXmlApplicationContext to load spring config file
        ApplicationContext context =new FileSystemXmlApplicationContext("web/WEB-INF/applicationContext.xml");
        Teacher t = context.getBean("myteacher1",Teacher.class);
        System.out.println(t.teach());
        System.out.println(t.motivate());
    }
}
