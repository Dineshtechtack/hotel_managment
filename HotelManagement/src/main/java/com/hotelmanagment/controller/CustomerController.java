package com.hotelmanagment.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotelmangment.dao.CustomerDao;
import com.hotelmangment.dao.HotelDeo;
import com.hotelmangment.entites.Admin;
import com.hotelmangment.entites.Customer;
import com.hotelmangment.entites.Hotel;
import com.hotelmangment.entites.product;

@Controller
public class CustomerController {
	@Autowired
    CustomerDao dao;
    @Autowired
    HotelDeo hoteldao;
    @RequestMapping("/Cus")
    public ModelAndView addCustomer()
    {
    	ModelAndView mav = new ModelAndView();
    	Customer ad=new Customer();
    	mav.addObject("Customerobj" ,ad);
    	mav.setViewName("Customerinform");
    	return mav;
    }
    @RequestMapping("/saveCustomerData")
     public ModelAndView savedata(@ModelAttribute("Customerobj") Customer customer)
     {
    	dao.savecustomer(customer);
    	ModelAndView mav= new ModelAndView();
    	mav.addObject("message","successfully add account");
    	mav.setViewName("Customerlogin");
    	return mav;
     }
    @RequestMapping("/Customerloginvalidation")
    public ModelAndView loginvalidation(ServletRequest request,HttpSession session )
    {
    Customer c=dao.loginvalidation(request.getParameter("email"),request.getParameter("password"));
     if(c!=null)
     {
    	 session.setAttribute("customerinfo", c);
 		ModelAndView mav =new ModelAndView();
 		mav.addObject("message","succesfully login");
 		mav.setViewName("Customeroption");
 		return mav;
 	}
 	else
 	{
 		ModelAndView mav =new ModelAndView();
 		mav.addObject("message","invalid candidate");
 		mav.setViewName("Customerlogin");
 		return mav;
 	}
     }
    @RequestMapping("/searchhotel")
    public ModelAndView searchhotel(ServletRequest request)
    {
    	String b=request.getParameter("hotelpro");
    	Hotel hotel=dao.findhotel(b);
    	ModelAndView mav=new ModelAndView();
    	mav.addObject("perticularhotel",hotel);
    	mav.setViewName("viewhotel");
		return mav;
    }
    @RequestMapping("/viewproducts")
    public ModelAndView viewproduct(@ModelAttribute("id") int id) {
		Hotel hotel=hoteldao.findhotelbyid(id);
		List<product>products=hotel.getProducts();
    	ModelAndView mav= new ModelAndView();
    	mav.addObject("viewproducts",products);
    	mav.setViewName("viewProduct");
    	return mav;
    }
  
}

