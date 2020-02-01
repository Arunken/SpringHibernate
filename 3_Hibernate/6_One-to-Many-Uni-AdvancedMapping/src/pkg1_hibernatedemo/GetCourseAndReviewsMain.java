
package pkg1_hibernatedemo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SilverDoe
 */
public class GetCourseAndReviewsMain {

    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class).
                addAnnotatedClass(Course.class).
                addAnnotatedClass(Review.class)
                .buildSessionFactory();
                
        Session session = factory.getCurrentSession();
        
        try 
        {
            //start transaction
            session.beginTransaction();
            

            int cid = 10;
            Course c = session.get(Course.class, cid);
            System.out.println(c);
            System.out.println(c.getReviews());
            
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
