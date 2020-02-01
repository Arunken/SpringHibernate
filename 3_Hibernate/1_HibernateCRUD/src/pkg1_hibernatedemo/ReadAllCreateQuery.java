/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg1_hibernatedemo;

import entity.Student;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SilverDoe
 */
public class ReadAllCreateQuery {
    
    // use Hibernate Query Language(HQL) for creating query
    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        
        try 
        {
            session.beginTransaction();
            
            //retrieve data of all students where the last name is 'Son'
            List<Student> listStudents = session.createQuery("from Student s where s.lastName='Son'")
                    .getResultList();// 'from Student' > Student is the class name
            
            for(Student stu:listStudents)
            {
                System.out.println(stu.getId()+", "+stu.getFirstName()+", "+stu.getLastName()+", "+stu.getEmail());
            }
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}

