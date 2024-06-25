package com.hotelmangment.dao;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hotelmangment.entites.Admin;

@Component
public class Admindao {
   @Autowired
  EntityManagerFactory  emf;
   @Autowired
   EntityManager em;
   @Autowired
   EntityTransaction et;
   
 public void save(Admin admin)
 {
	 et.begin();
	 em.persist(admin);
	 et.commit();
 }
 public Admin loginadmin(String email,String password)
	{
		Query query=em.createQuery("select c from Admin c where c.email=?1 and c.password=?2");
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		try {
			return (Admin) query.getSingleResult();
		} catch ( NoResultException  e) {
			  return null;
		}
		
	}
	}


