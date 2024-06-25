package com.hotelmanagment.controller;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.hotelmangment.entites.Admin;
@Controller
public class Admincontroller {
   @Autowired
   com.hotelmangment.dao.Admindao dao;
@RequestMapping("/addRegister")
public ModelAndView adduser() {
	
	ModelAndView mav = new ModelAndView();
	Admin ad=new Admin();
	mav.addObject("adminobj" ,ad);
	mav.setViewName("AdminRegister");
	return mav;
}
@RequestMapping("/saveData")
public ModelAndView SaveAdmin(@ModelAttribute("adminobj") Admin admin)
{
	dao.save(admin);
	ModelAndView mav=new ModelAndView();
	mav.addObject("message","account is added succesfully");
	mav.setViewName("Adminlogin");
	return mav;
}
@RequestMapping("/LoginValidation")
public ModelAndView adminlogin(ServletRequest request,HttpSession h)
{
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	
Admin a	=dao.loginadmin(email, password);
System.out.println(a);
ModelAndView mav=new ModelAndView();
if(a!= null)
{
	System.out.println("this is enter into admin ");
	h.setAttribute("adminfo", a);
	mav.addObject("message", "login done");
	mav.setViewName("Adminoption");
	return mav;
}
else
{
	mav.addObject("message","invalidcandidate");
	mav.setViewName("Adminlogin");
	return mav;
}

}

}


