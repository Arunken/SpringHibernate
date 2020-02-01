
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
public class DeleteMain {

    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class).
                addAnnotatedClass(InstructorDetail.class)// add the classes to session factory
                .buildSessionFactory();
                
        Session session = factory.getCurrentSession();
        
        try 
        {
            
            //start transaction
            session.beginTransaction();
            
            int inid =1;
            Instructor instructor = session.get(Instructor.class, inid);
            
            // if the id is nonexistent then a null object will be returned
            if(instructor==null)
            {
                System.out.println("no user exists for the id "+inid);
            }
            else
            {
                System.out.println("Deleting : "+instructor);
                session.delete(instructor);//** will also delete detail as cascadeType is set to All
            }
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
