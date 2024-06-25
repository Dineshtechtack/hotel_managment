package com.hotelmanagment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hotelmangment.dao.HotelDeo;
import com.hotelmangment.dao.ProductDao;
import com.hotelmangment.entites.Hotel;
import com.hotelmangment.entites.product;

@Controller
public class ProductController {
    @Autowired
	ProductDao dao;
    @Autowired
    HotelDeo hodao;
	@RequestMapping("/addproduct")
	public ModelAndView addproduct() {
		product p=new product();
		ModelAndView b= new  ModelAndView();
		b.addObject("productobjs", p);
		b.setViewName("productform");
		return b;
	}
	@RequestMapping("/saveproduct")
	//this handler is used to save the product 
	public ModelAndView saveproduct(@ModelAttribute("productobj") product product, HttpSession session)
	{
		 Integer hotel_id=(Integer)session.getAttribute("Hotelinfo");
		 Hotel hotel =hodao.findhotelbyid(hotel_id);
		 List<product>products =hotel.getProducts();
		 if(products.size()>0)
		 {
			 products.add(product);
			hotel.setProducts(products);
		 }
		 else
		 {
			 List<product> productList = new ArrayList<product>();
			 productList.add(product);
			 hotel.setProducts(productList);
		 } 
		 dao.saveproduct(product);
		 hodao.updateHotel(hotel);
		 ModelAndView mav= new ModelAndView();
		 mav.addObject("message", "added succesfully");
		 mav.setViewName("hoteloption");
		 return mav;
	}
	 @RequestMapping("/viewAllproduct")
	    public ModelAndView viewproduct(HttpSession session) {
		    Integer id=(Integer) session.getAttribute("Hotelinfo");
		     Hotel hotel=hodao.findhotelbyid(id);
			List<product>products=hotel.getProducts();
    
		
		    	ModelAndView mav= new ModelAndView();
		    	mav.addObject("viewhotelproducts",products);
		    	mav.setViewName("hotelsviewproducts");
		    	return mav;
}
	 @RequestMapping("/updateProducts")
	 public ModelAndView updateproducts(HttpSession session) {
		  Integer id=(Integer) session.getAttribute("Hotelinfo");
		     Hotel hotel=hodao.findhotelbyid(id);
		     
		    	ModelAndView mav= new ModelAndView();
		    	mav.setViewName("redirect://viewAllproduct");
		        return mav;
	 }
    //hoteloption
    @RequestMapping("/updateproductser")
    public ModelAndView modifyproducts(@RequestParam("id") int id) {
    	product pcs=dao.findproductwithid(id);
    	ModelAndView mav= new ModelAndView();
        //updateform
        mav.addObject("updateproductsform",pcs);
    	mav.setViewName("updateform");
    	return mav;
    }
    @RequestMapping("/poductupdate")
    public ModelAndView update(@ModelAttribute("updateproductsform") product prc)
    {
    	dao.updateproduct(prc);
    	ModelAndView mav= new ModelAndView();
        //redirect to view all products
    	mav.setViewName("redirect://viewAllproduct");
    	return mav;
    }
    @RequestMapping("/deleteproducts")
    public ModelAndView delete(HttpSession session ,@RequestParam("id") int id) {
    	int id1=(int) session.getAttribute("Hotelinfo");
    	Hotel hotel=hodao.findhotelbyid(id1);
    	List<product>pcts=hotel.getProducts();
    	List<product> products=new ArrayList<product>();
    	for(product prod:pcts)
    	{
    		if(prod.getId()!=id) {
    		products.add(prod);
    		}
    	}
    	hotel.setProducts(products);
    	dao.deleteproduct(id);
    	ModelAndView a=new ModelAndView();
    	a.setViewName("redirect://viewAllproduct");
    	return a;
    }
    @RequestMapping("/fetchallproducts")
    public ModelAndView fetchallproducts() {
    	List<product>pro=(List<product>) dao.fetchproducts();
    	ModelAndView mav=new ModelAndView();
    	mav.addObject("rangeofproducts",pro);
    	mav.setViewName("displayAllproductsforcustomer");
		return mav;
 }
 // this handler is used to handle the request.
  @RequestMapping("/rangeof_the_product")
  public ModelAndView fetchallproducts_range(ServletRequest request) {
  	List<product> p=(List<product>) dao.fetchProductbetweenrange(Double.parseDouble(request.getParameter("range_of_starting_price")),Double.parseDouble(request.getParameter("range_of_ending_price")));
  	ModelAndView mav=new ModelAndView();
  	mav.addObject("rangeofproducts",p);
  	mav.setViewName("Fetching_product_Range");
		return mav;
 }
  
    }

