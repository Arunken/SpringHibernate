
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
public class DeleteInstructorDetailBidirectional {

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
            
            int inid =3;
            // WE ARE GOING TO USE INSTRUCTORDETAIL TO DELETE as we are using bidirectional mapping
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, inid);
            
            Instructor instructor= instructorDetail.getInstructor();// access instructor using instuctordetail because of bidirectional
            System.out.println(instructor);
            
            //**** delete the instructor details>>> this deletes instructor because we have cascadingType as ALL
            session.delete(instructorDetail);
            
            //commit the transaction
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally 
        {
            // remove any leaks in code when exception occurs
            session.close();
            factory.close();
        }
    }
}
