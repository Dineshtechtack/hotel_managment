package com.hotelmangment.helper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
@ComponentScan(basePackages ="com")
@Configuration
public class configurationclass {

@Bean
public EntityManagerFactory getEMF()
{
	return Persistence.createEntityManagerFactory("Hotel");
}
@Bean
public EntityManager getEm()
{
	return getEMF().createEntityManager();	
}
@Bean
public EntityTransaction getET()
{
	return getEm().getTransaction();
}
}
