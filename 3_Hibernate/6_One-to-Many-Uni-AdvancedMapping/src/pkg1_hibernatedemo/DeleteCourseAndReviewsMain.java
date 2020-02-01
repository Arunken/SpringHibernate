
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
public class DeleteCourseAndReviewsMain {

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
            session.delete(session.get(Course.class, cid));// deleting a  course will delete all its reviews
                                                           //as well because of cascading delete
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
