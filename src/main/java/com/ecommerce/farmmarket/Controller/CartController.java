package com.ecommerce.farmmarket.Controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.farmmarket.model.Animal;
import com.ecommerce.farmmarket.model.Cart;
import com.ecommerce.farmmarket.model.Customer;
import com.ecommerce.farmmarket.model.Orders;
import com.ecommerce.farmmarket.service.AnimalService;
import com.ecommerce.farmmarket.service.CartService;
import com.ecommerce.farmmarket.service.CustomerService;
import com.ecommerce.farmmarket.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController
{
	@Autowired
	private CartService crs;
	@Autowired
	private CustomerService cs;
	@Autowired
	private AnimalService as;
	@Autowired
	private OrderService orderService;
    @RequestMapping("/cart")
    public ModelAndView saveCart(@RequestParam("customerId") int cid,
    		@RequestParam("animalId") int aid,HttpSession session)
    {
    	ModelAndView mv=new ModelAndView();
    	Cart cr=new Cart(cid,aid);
    	Cart crt=crs.saveCart(cr);
    	if(crt==null)
    	{
    		mv.addObject("res","failed to add cart try again");
    	}
    	else
    	{
    		mv.addObject("res","added to cart");
    	}
    	List<Orders> o=orderService.getOrders(cid);
    	Customer customer=cs.getCustomer(cid);
    	List<Cart> cartItems=crs.getCartItems(cid);
    	mv.addObject("cartItems",cartItems);
    	mv.addObject("animals",as.getAnimals());
    	mv.addObject("orders",o);
    	mv.addObject("customer",customer);
        mv.addObject("customerid", customer.getCid());
        session.setAttribute("res", "added to cart successfully!");
        mv.setViewName("AnimalHome");
    	return mv;
    }
    @RequestMapping("/getCartItems")
    public ModelAndView getCartItems(@RequestParam("cid") int cid)
    {
    	ModelAndView mv=new ModelAndView();
    	List<Animal> animals=new ArrayList<Animal>();
    	List<Cart> cartItems=crs.getCartItems(cid);
    	if(cartItems==null)
    	{
    		
    	}
    	else
    	{
    		for(Cart c: cartItems)
    		{
    			animals.add(c.getAnimal());
    		}
    	}
     	mv.addObject("animals",animals);
    	mv.addObject("customer",cs.getCustomer(cid));
    	mv.setViewName("CartDetails");
    	return mv;
    }
}
