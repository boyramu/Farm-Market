package com.ecommerce.farmmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.farmmarket.Repository.OrderRepo;
import com.ecommerce.farmmarket.model.Orders;

@Service
public class OrderService 
{
	@Autowired
	private OrderRepo or;
   public Orders saveOrder(Orders o)
   {
	   return or.save(o);
   }
   public List<Orders> getOrders(int cid) {
	    return or.findByCustomerCid(cid);
	}

   
}
