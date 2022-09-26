package com.greatlearning.crmapp.service;

import com.greatlearning.crmapp.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class CustomerServiceImpl implements CustomerService{

	private SessionFactory sessionFactory;
	
	// create session
	private Session session;
	
	@Autowired
	CustomerServiceImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}
	
	@Transactional
	public List<Customer> findAll() {
		Transaction tx = session.beginTransaction();

		// find all the records from the database table
//		List<Customer> customers=session.createQuery("from customer").list();
		List<Customer> customers = session.createQuery("From Customer").list();
		tx.commit();
		return customers;
	}

	@Transactional
	public Customer findById(int id) {
		
		Transaction tx = session.beginTransaction();
		
		Customer customer = session.get(Customer.class, id);

		tx.commit();


		return customer;

	}
	
	@Transactional
	public void save(Customer theCustomer) {

		Transaction tx = session.beginTransaction();

		// save transaction
		session.saveOrUpdate(theCustomer);


		tx.commit();


	}
	
	@Transactional
	public void deleteById(int id) {

		Transaction tx = session.beginTransaction();

		// get transaction
		Customer customer = session.get(Customer.class, id);

		// delete record
		session.delete(customer);

		tx.commit();

	}
}
