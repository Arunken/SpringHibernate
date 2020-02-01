
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
public class GetInstructorCoursesMain {

    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class)
                .buildSessionFactory();
                
        Session session = factory.getCurrentSession();
        
        try 
        {
            //start transaction
            session.beginTransaction();
            
            // get an instructor to allocate new courses
            int inid = 1;
            Instructor instructor = session.get(Instructor.class, inid);
            
            System.out.println(instructor);
            System.out.println(instructor.getCourses());
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
