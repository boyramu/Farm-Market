package com.ecommerce.farmmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.farmmarket.Repository.CartRepo;
import com.ecommerce.farmmarket.model.Cart;

@Service
public class CartService
{
	@Autowired
	private CartRepo cartRepo;
    public Cart saveCart(Cart c)
    {
    	return cartRepo.save(c);
    }
    public List<Cart> getCartItems(int cid)
    {
    	return cartRepo.findByCustomerCid(cid);
    }
	
}
