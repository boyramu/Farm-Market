package com.ecommerce.farmmarket.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.farmmarket.model.Customer;
import com.ecommerce.farmmarket.model.Orders;
import com.ecommerce.farmmarket.service.AnimalService;
import com.ecommerce.farmmarket.service.CartService;
import com.ecommerce.farmmarket.service.CustomerService;
import com.ecommerce.farmmarket.service.OrderService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerSignp 
{
	@Autowired
	private CustomerService cs;
	@Autowired
	private AnimalService as;
	@Autowired
	private OrderService os;
	@Autowired
	private CartService csr;
   @RequestMapping("/signup")
   public ModelAndView CuustomerSignup(HttpSession session,@RequestParam("fullName") String fullname,
		   @RequestParam("address") String address,@RequestParam("phoneNumber") String phoneNumber,
		   @RequestParam("email") String email,@RequestParam("password") String password)
   {
	   ModelAndView mv=new ModelAndView();
	   Customer c=new Customer(fullname,address,phoneNumber,email,password);
	   if(cs.saveCustomer(c)==null)
	   {
       session.setAttribute("res", "signup failed try agian");
	   }
	   else
	   {
		   session.setAttribute("res", "signup sucess signin now");   
	   }
	   mv.setViewName("index");
	   return mv;
   }
   @RequestMapping("/signin")
   public ModelAndView CuustomerSignIn(HttpSession session,@RequestParam("email") String email,@RequestParam("password") String password)
   {
	   ModelAndView mv=new ModelAndView();
	   Customer c=new Customer();
	   c.setEmail(email);
	   c.setPassword(password);
	   Customer oc=cs.loginCustomer(c);
	   if(oc==null)
	   {
		   session.setAttribute("res", "Invalid email "); 
		  mv.setViewName("index");
		   
	   }
	   else
	   {
		   
		   if(email.equals(oc.getEmail())&&password.equals(oc.getPassword()))
		   {
			   
			   List<Orders> o=os.getOrders(oc.getCid());
			   mv.addObject("cartItems",csr.getCartItems(oc.getCid()));
			   mv.addObject("animals",as.getAnimals());
			   mv.addObject("customer",oc);
			   mv.addObject("orders",o);
			   mv.setViewName("AnimalHome");
			   
		   }
		   else
		   {
			   session.setAttribute("res", "wrong password");
			   mv.setViewName("index");
			   
		   }
	   }
	   
	   return mv;
   }
   
}
