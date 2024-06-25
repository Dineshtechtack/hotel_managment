package com.hotelmanagment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotelmangment.dao.CustomerDao;
import com.hotelmangment.dao.ItemDao;
import com.hotelmangment.dao.ProductDao;
import com.hotelmangment.dao.food_orderDao;
import com.hotelmangment.entites.Customer;
import com.hotelmangment.entites.food_order;
import com.hotelmangment.entites.item;
import com.hotelmangment.entites.product;

@Controller
public class itemcontroller {
  @Autowired
  ItemDao dao;
  @Autowired
  CustomerDao cusDao;
  @Autowired
  ProductDao proDao ;
  @RequestMapping("/add_product_tolist")
  public ModelAndView addproduct(@RequestParam("id") int id)
  {
	  item items=new item();
	  product products=proDao.findproductwithid(id);
	  items.setName(products.getName());
	  items.setCost(products.getCost());
	  ModelAndView mav=new ModelAndView();
	 mav.addObject("product_into_list",items);
	 mav.setViewName("product_to_list_jpqlform");
	 return mav;
	  
}
  @RequestMapping("/Save_products_into_list")
	public ModelAndView add_tocart(@ModelAttribute("itemobj") item i,  HttpSession session)
	{
		ModelAndView mav=new ModelAndView();
			List<item>	items=(List<item>) session.getAttribute("itemlist");
		  i.setCost(i.getCost()*i.getQuantity());
		if(items == null)
		{
			List<item> item2=new ArrayList<item>();
			
			item2.add(i);
			session.setAttribute("itemlist", item2);
		}
		else
		{
			items.add(i);
			
		}
		mav.addObject("message", "added successfully");
		mav.setViewName("displayAllproductsforcustomer");
		return mav;
	} 
//  @RequestMapping("/ordereditems")
//	public ModelAndView ordered_item(@RequestParam("id")int id)
//	{
//		food_order items=fodao.findfoodorder(id);
//		
//		ModelAndView mav=new ModelAndView();
//		mav.addObject("itemsobj", items.getItems());
//		mav.setViewName("vieworderitem");
//		return mav;
//	}
//	
  @RequestMapping("/delete")
	public ModelAndView update_item(@RequestParam("name")String name,HttpSession session)
	{
			List<item> items=(List<item>) session.getAttribute("itemlist");
			
			List<item> newitems=new ArrayList<item>();
			
			for(item i: items)
			{
				if(i.getName().equals(name))continue;
				
				newitems.add(i);
			}
			session.setAttribute("itemlist", newitems);
			
			ModelAndView mav=new ModelAndView();
			mav.addObject("message", "item removed successfully");
			mav.setViewName("viewlistofproducts");
			return mav;
	}
  @RequestMapping("/showlistofitems")
  public ModelAndView placeorder(HttpSession session )
  {
       List<product>list=(List<product>) session.getAttribute("itemlist");
       ModelAndView mav=new ModelAndView();
       mav.addObject("itemsobj",list);
       mav.setViewName("viewlistofproducts");
	return mav;
  }
 
  }

