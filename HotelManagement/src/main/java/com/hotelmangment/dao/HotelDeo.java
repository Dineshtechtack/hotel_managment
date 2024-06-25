package com.hotelmangment.dao;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotelmangment.entites.Admin;
import com.hotelmangment.entites.Hotel;


@Component
public class HotelDeo {
	   @Autowired
	  EntityManagerFactory  emf;
	   @Autowired
	   EntityManager em;
	   @Autowired
	   EntityTransaction et;
	   
	 public void save(Hotel hotel)
	 {
		 et.begin();
		 em.persist(hotel);
		 et.commit();
	 }
	public Hotel loginvalidation(String email, String password) {

		 try {
		        Query query = em.createQuery("SELECT A FROM Hotel A WHERE A.email = :email AND A.password = :password");
		        query.setParameter("email", email);
		        query.setParameter("password", password);
		        return (Hotel) query.getSingleResult();
		    } catch (Exception e) {
		        // Handle case where no result is found
		        return null;
		    }
	}
	public Hotel findhotelbyid(int hotel_id) {
		 return em.find(Hotel.class, hotel_id); 
	}
	public void updateHotel(Hotel hotel) {
	    et.begin();
		em.merge(hotel);
		et.commit();
	}
	public void deleteHotel(int id)
	{
		et.begin();
		em.remove(em.find(Hotel.class, id));
		et.commit();
	}
	public List<Hotel> approved(String m)
	{
		Query query=em.createQuery("select A from Hotel A where A.status=?1");
		query.setParameter(1, m);
		return query.getResultList();
	}
	public List fetchdata()
	{
		Query query=em.createQuery("select A from Hotel A ");
		return query.getResultList();
	}
	}


