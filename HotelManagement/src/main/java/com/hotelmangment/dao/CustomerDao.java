package com.hotelmangment.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotelmangment.entites.Customer;
import com.hotelmangment.entites.Hotel;
@Component
public class CustomerDao {
	
	@Autowired
	EntityManagerFactory emf;
	
	@Autowired
	EntityManager em;
	
	@Autowired
	EntityTransaction et;
	
	public  void savecustomer(Customer c)
	{
		et.begin();
		em.persist(c);
		et.commit();
	}
	
	public Customer findcustomer(int id)
	{
		return em.find(Customer.class, id);
		
	}
	
	public void updatecustomer(Customer c)
	{
		et.begin();
		em.merge(c);
		et.commit();
	}
	public void deletecustomer(int id)
	{
		et.begin();
		em.remove(findcustomer(id));
		et.commit();
	}
	
	public Customer loginvalidation(String email,String password)
	{
		Query query=em.createQuery("select c from Customer c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		try {
			return (Customer) query.getSingleResult();
		} catch ( NoResultException  e) {
			return null;
		}
		
	}

	public Hotel findhotel(String hotelname) {
		Query query =em.createQuery("select A from Hotel A where A.name=?1");
		query.setParameter(1, hotelname);
		try {
		return (Hotel)query.getSingleResult();
		}catch(NullPointerException e)
		{
			return null;
		}
	}

}
