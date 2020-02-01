
package pkg1_hibernatedemo;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author SilverDoe
 */
public class CreateMain {

    /**
     * ========= Session Factory ====================
     * Reads the hibernate config file.
     * Creates session objects.
     * Heavy-weight object.
     * Only create once in your app. Once created it is reused throughout
     
     * ========= Session ============================
     * Wraps a JDBC connection
     * Main object used to save/retrieve objects
     * short-lived object
     * Retrieved from SessionFactory
     */
    public static void main(String[] args) {
      
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class).buildSessionFactory();
               // if no name is given inside the configure(...) method then 
                // Hibernate will look for the default file name: hibernate.cfg.xml 
                
        Session session = factory.getCurrentSession();
        
        try 
        {
            //student object
            Student stu = new Student("Gohan", "Son", "mail.songohan@gmail.com");
            
            //start transaction
            session.beginTransaction();
            
            //save the student
            Integer id = (Integer)session.save(stu);
            System.out.println("Id of inserted record : "+id);// generated id for the record in the DB
            System.out.println("get id : "+stu.getId());// generated id for the record in the DB
            
            
            //commit the transaction
            session.getTransaction().commit();
        } finally 
        {
            factory.close();
        }
    }
}
