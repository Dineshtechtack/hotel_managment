package com.hotelmangment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.hotelmangment.entites.Hotel;
import com.hotelmangment.entites.product;
@Component
public class ProductDao {

@Autowired
EntityManagerFactory emf;
@Autowired
EntityManager em;
@Autowired
EntityTransaction et;
public void saveproduct(product p) {
	        et.begin();
	        em.persist(p);
	        et.commit();
}
public void updateproduct(product products) {
	em.merge(products);
	et.commit();   
}
public void deleteproduct(int id)
{
	et.begin();
	em.remove(em.find(product.class, id));
	et.commit();
}
public List<product> fetchproducts() {
    return em.createQuery("select A from product A ").getResultList();
}

public List<product> fetchProductbetweenrange(double minvalue,double maxvalue )
{
Query query =em.createQuery("select A from product A where A.cost between ?1 and ?2 ");
query.setParameter(1, (int)minvalue);
query.setParameter(2, (int)maxvalue);
return (List<product>) query.getResultList();
}
public product findproductwithid(int id) {
	 et.begin();
	return  em.find(product.class, id);
	 
}

}
