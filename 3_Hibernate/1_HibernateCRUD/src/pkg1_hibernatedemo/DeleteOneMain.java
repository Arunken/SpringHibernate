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
public class DeleteOneMain {
    
    // delete the value after retreiving the object having a specific id
    
    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
 
                
        Session session = factory.getCurrentSession();
        
        try 
        {
            

            session.beginTransaction();
            
            //delete the student having id of 4
            Integer stuid = 4;
            Student stu = session.get(Student.class, stuid);
            session.delete(stu);
            
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
   
