package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Customer;

@Repository // for DAO implementations that needs to be component scanned. @Controller, @Service and @Repository are subclasses of @Component
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate session
		Session session =  sessionFactory.getCurrentSession();
		
		//create a query
		Query<Customer> theQuery = session.createQuery("from Customer order by firstName",Customer.class);
		
		//execute query and get result list
		List<Customer> customers = theQuery.getResultList();
		
		// return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//save the customer
		//session.save(theCustomer);
		
		//save or update the customer depending on the id
		session.saveOrUpdate(theCustomer);
		
	}

	@Override
	public Customer getCustomer(int theId) {
		
		//get the current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Customer theCustomer = session.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		//Customer theCustomer = session.get(Customer.class, theId);
		//session.delete(theCustomer);
		//OR
		
		Query theQuery = session.createQuery("delete from Customer where id=:theCustomerId");
		theQuery.setParameter("theCustomerId", theId);
		theQuery.executeUpdate();
	}

}
