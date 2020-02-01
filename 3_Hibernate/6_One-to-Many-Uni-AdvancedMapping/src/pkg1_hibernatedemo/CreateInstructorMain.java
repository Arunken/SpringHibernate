
package pkg1_hibernatedemo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SilverDoe
 */
public class CreateInstructorMain {

    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class)
                .buildSessionFactory();
                
        Session session = factory.getCurrentSession();
        
        try 
        {
            // create objects
            Instructor instructor = new Instructor("Erza", "Scarlet", "mail.scarlet@gmail.com");
            
            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com/scarlet", "animes");
            
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
