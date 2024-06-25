package com.hotelmangment.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;
@Column(unique=true)
 private String email;
 private String password;
 private String mobilenumber;
 private String Address;
 @OneToMany
 List<food_order> order;
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMobilenumber() {
	return mobilenumber;
}
public void setMobilenumber(String mobilenumber) {
	this.mobilenumber = mobilenumber;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
private String name;
public List<food_order> getOrder() {
	return order;
}

public void setOrder(List<food_order> order) {
	this.order = order;
}
}
