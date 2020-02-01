
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
public class CreateCoursesMain {

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
            
            //create courses for the instructor
            Course c1 = new Course("Dragon Slayer Magic");
            Course c2 = new Course("How to be a Challenger");
            
            // add these courses to instructor
            instructor.add(c1);
            instructor.add(c2);
            
            //save the courses
            session.save(c1);
            session.save(c2);
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
