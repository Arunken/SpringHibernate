
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
            
            // get an instructor to allocate new courses
            int inid = 1;
            Instructor instructor = session.get(Instructor.class, inid);// courses are set to Eager fetch type initially
            
            System.out.println(instructor);// eager fetching...look at the output for fetching query...it fetches instructor, instructor detail and courses
                                           //change the fetching type to lazy and see two hql queries being executed at the output to fetch
                                           
            // if i am using lazy loading and that i have closed the session, then the following 
            // code will give an error because it needs to fetch the data from the database
            System.out.println(instructor.getCourses());
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
