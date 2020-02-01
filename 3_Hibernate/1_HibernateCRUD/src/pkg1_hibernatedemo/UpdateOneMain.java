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
public class UpdateOneMain {
 
    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
               // if no name is given inside the configure(...) method then 
                // Hibernate will look for the default file name: hibernate.cfg.xml 
                
        Session session = factory.getCurrentSession();
        
        try 
        {

            
            //start transaction
            session.beginTransaction();
            
            Integer id = 1;
            Student stu = session.get(Student.class, id);
            stu.setFirstName("Aru");
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}

