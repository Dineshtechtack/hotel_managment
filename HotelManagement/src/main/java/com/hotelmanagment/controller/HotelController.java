package com.hotelmanagment.controller;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotelmangment.dao.HotelDeo;
import com.hotelmangment.entites.Admin;
import com.hotelmangment.entites.Hotel;
@Controller
public class HotelController {

	@Autowired
	HotelDeo dao;
	@RequestMapping("/addhotel")
	public ModelAndView addHotel() {
		ModelAndView mav = new ModelAndView();
		
		Hotel ad= new Hotel();
		mav.addObject("Hotelobj" ,ad);
		mav.setViewName("Hotelform");
		return mav;
	}
	@RequestMapping("/savehoteldata")
	public ModelAndView SaveHotel(@ModelAttribute("Hotelobj") Hotel hotel)
	{
		dao.save(hotel);
		ModelAndView mav=new ModelAndView();
		
		mav.addObject("message","account is added succesfully");
		mav.setViewName("HotelLogin");
		return mav;
	}
	@RequestMapping("/Homeloginvalidation")// this hander used to handle to loginvalidation 
	public ModelAndView loginvalidation(ServletRequest request ,HttpSession session )
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		Hotel a=dao.loginvalidation(email,password);
		if(a!=null)
		{
			if(a.getStatus().equals("approved")) {
			session.setAttribute("Hotelinfo", a.getId());
			
			ModelAndView mav =new ModelAndView();
			mav.addObject("message","succesfully login");
			mav.setViewName("hoteloption");
			return mav;
			}
		else if(a.getStatus().equals("unapproved"))
		{   
			ModelAndView mav =new ModelAndView();
			mav.addObject("message", "your hotel in admin perpastive");
			return mav;
		}
		else
		{
			ModelAndView mav =new ModelAndView();
			mav.addObject("message","your account in block in status  contact admin");
			mav.setViewName("HotelHome");
			return mav;
		}
	}	
		else {
			ModelAndView mav =new ModelAndView();
			mav.addObject("message","invalid candidate");
			mav.setViewName("HotelLogin");
			return mav;
		}
}
	@RequestMapping("/fetchallhotel")
	public ModelAndView fetchhotel()
	{
		List<Hotel> hotel=dao.fetchdata();
		
		  ModelAndView b= new ModelAndView();
		  b.addObject("fetchhotels",hotel);
		  b.setViewName("fetchunapprovelhotel");
		return b;
	}
	@RequestMapping("/approvehotel")
	public ModelAndView unapprovelhotel(@RequestParam("id") int id)
	{
		Hotel h=dao.findhotelbyid(id);
		h.setStatus("unapproved");
	    dao.updateHotel(h);
	    
	    ModelAndView mav=new ModelAndView();
	    mav.setViewName("redirect://unapprovel");
	    return mav;
	}
	@RequestMapping("/unapprovehotel")
	public ModelAndView approvelhotel(@RequestParam("id") int id)
	{
		Hotel h=dao.findhotelbyid(id);
		h.setStatus("approved");
	    dao.updateHotel(h);
	    
	    ModelAndView mav=new ModelAndView();
	    mav.setViewName("redirect://approvel");
	    return mav;
	}
	
	@RequestMapping("/unapprovel")
	public ModelAndView fetchunapprovedHotel()
      {
		List<Hotel> hotel=dao.approved("approved");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("unapproved",hotel);
		mav.setViewName("unapprovel");
		return mav;
	 }
	@RequestMapping("/approvel")
	public ModelAndView fetchapprovedHotel()
      {
		List<Hotel> hotel=dao.approved("unapproved");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("unapproved",hotel);
		mav.setViewName("approve");
		return mav;
	 }
	@RequestMapping("/blockhotels")
	public ModelAndView blockhotel()
      {
		List<Hotel> hotel=dao.fetchdata();
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("block",hotel);
		mav.setViewName("HotelBlock");
		return mav;
	 }
	@RequestMapping("/unblockhotels")
	public ModelAndView unblockhotel()
      {
		List<Hotel> hotel=dao.approved("block");
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("block",hotel);
		mav.setViewName("hotelunblock");
		return mav;
	 }
	@RequestMapping("/block")
	public ModelAndView blocklhotel(@RequestParam("id") int id)
	{
		System.out.println(id);
		Hotel h=dao.findhotelbyid(id);
		h.setStatus("block");
	    dao.updateHotel(h);
	    
	    ModelAndView mav=new ModelAndView();
	    mav.setViewName("redirect://blockhotels");
	    return mav;
	}
	@RequestMapping("/unblock")
	public ModelAndView unblocklhotel(@RequestParam("id") int id)
	{
		
		Hotel h=dao.findhotelbyid(id);
		h.setStatus("approved");
	    dao.updateHotel(h);
	    
	    ModelAndView mav=new ModelAndView();
	    mav.setViewName("redirect://unblockhotels");
	    return mav;
	}
}
