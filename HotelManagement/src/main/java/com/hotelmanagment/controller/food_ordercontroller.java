package com.hotelmanagment.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hotelmangment.dao.food_orderDao;
import com.hotelmangment.entites.food_order;
import com.hotelmangment.entites.item;

public class food_ordercontroller {
   
	@Autowired
	food_orderDao dao;
	int sum=0;
	@RequestMapping("/order_items")
	public ModelAndView order(HttpSession session ) {
		food_order fd=new food_order();
		fd.setItems((List<item>)session.getAttribute("itemlist"));
		
		for(item it:fd.getItems())
		{
		    sum+=it.getCost();
		}
		fd.setTotalcost(sum);
		ModelAndView mav=new ModelAndView();
		mav.addObject("addcustomerobj",fd);
		mav.setViewName("food_ordercustomerimformation");
		return mav;
	}
	@RequestMapping("/procide_to_pay")
	public ModelAndView payment(@ModelAttribute("addcustomerobj") food_order fd ,HttpSession session)
	{
		if(fd.getPayment().equals("not_payed"))
		{
			ModelAndView mav=new ModelAndView();
			mav.addObject("addcustomerobj",fd);
			session.setAttribute("ordercustomer", fd);
			mav.setViewName("food_ordercustomerimformation");
			return mav; 
		}
		else
		{
			dao.saveprodcuts(fd);
			ModelAndView mav=new ModelAndView();
			mav.addObject("message","orderplacedsuccessfully");
			mav.setViewName("print_the_recepit");
			return mav;
		}
		}
	}
