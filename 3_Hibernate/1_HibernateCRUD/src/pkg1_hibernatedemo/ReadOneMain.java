/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_hibernatedemo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SilverDoe
 */
public class ReadOneMain {
    
    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        
        try 
        {
            session.beginTransaction();
            Integer id = 3; // id of any student record you want to retrieve
            
            //retrieve data
            Student stu = session.get(Student.class, 3);
            System.out.println("Retrieved data : "+stu);
            
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}

