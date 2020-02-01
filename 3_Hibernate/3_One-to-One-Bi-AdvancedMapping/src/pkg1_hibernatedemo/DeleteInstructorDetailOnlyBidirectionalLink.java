
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
public class DeleteInstructorDetailOnlyBidirectionalLink {

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
            
            int inid =5;
            // WE ARE GOING TO USE INSTRUCTORDETAIL TO DELETE as we are using bidirectional mapping
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, inid);
            
            Instructor instructor= instructorDetail.getInstructor();// access instructor using instuctordetail because of bidirectional
            System.out.println(instructor);
            
            // Change the cascadeType in instructor detail for the instructor object to everything other than remove
            //@OneToOne(mappedBy = "instructorDetail", cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
            
            //**** delete the instructor detail only...this will give an error as we have removed the cascade type of ALL and set the cascade type
            // as everything except REMOVE for the instructor object. But there is a bidirectional link that would cause instructor object to be removed as well
            //which isn't possible because there is no cascading type set to remove
            // We need to break the bidirectional link inorder to delete the instructor detail only...
            //this can be done by setting instructor detail object in instructor class to null before deleting instructor detail
            // that is to remove deleted object from associations
            // otherwise deleted object would be re-saved by cascade
            instructor.setInstructorDetail(null);
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
