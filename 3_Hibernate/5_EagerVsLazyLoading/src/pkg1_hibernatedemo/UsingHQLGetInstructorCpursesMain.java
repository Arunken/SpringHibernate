
package pkg1_hibernatedemo;

import entity.Course;
import entity.Instructor;
import entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author SilverDoe
 */
public class UsingHQLGetInstructorCpursesMain {
    //***=========== Fetching Data ===============
    //>> Eager loading : load main entity and all the dependent entities(performance issue when deailing with large dependent data)
    //>> Lazy loading :  load main entity and load dependent entities on demand
    
    //***=========== Mapping and default fetch type ============
    //>> @OneToOne - FetchType.EAGER
    //>> @OneToMany - FetchType.LAZY
    //>> @ManyToOne - FetchType.EAGER
    //>> @ManyToMany - FetchType.LAZY
    
    // You can override the default fetch type by providing fetch type while mapping as follows :
    
    // @ManyToOne(fetch=FetchType.LAZY)

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
            
            
            int inid = 1;
            
            //import org.hibernate.query.Query;
            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "where i.id=:insid",
                    Instructor.class);
            
            query.setParameter("insid", inid);
            
            // execute 
            Instructor instructor = query.getSingleResult();
            
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
