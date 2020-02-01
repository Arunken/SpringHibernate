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
public class UpdateBulkCreateQuery {
    
    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
                
        Session session = factory.getCurrentSession();
        
        try 
        {
            session.beginTransaction();
            
            //update email for all students
            session.createQuery("update Student set email='user@gmail.com'")
                    .executeUpdate();
            
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}