
package pkg1_hibernatedemo;

import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SilverDoe
 */
public class CreateMain {

    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class)// add the classes to session factory
                .buildSessionFactory();
                
        Session session = factory.getCurrentSession();
        
        try 
        {
            // create objects
            Instructor instructor = new Instructor("Arun1", "Ken", "mail.arunken@gmail.com");
            
            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/kenrig", "animes");
            
            //** associate the objects
            instructor.setInstructorDetail(instructorDetail);
            
            //start transaction
            session.beginTransaction();
            
            session.save(instructor); // this will also save the detail object
                                                            // because of CascadeType.All
            System.out.println("Saved Id : "+instructor.getId());
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
