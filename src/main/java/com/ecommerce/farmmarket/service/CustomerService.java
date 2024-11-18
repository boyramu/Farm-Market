package com.ecommerce.farmmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.farmmarket.Repository.CustomerRepo;
import com.ecommerce.farmmarket.model.Customer;

@Service
public class CustomerService 
{
	@Autowired
	private CustomerRepo customerRepo;
  public Customer saveCustomer(Customer c)
  {
	   return customerRepo.save(c);
  }
  public Customer loginCustomer(Customer c)
  {
	  return customerRepo.findByEmail(c.getEmail());
  }
  public Customer getCustomer(int cid)
  {
	  return customerRepo.findById(cid).orElse(null);
  }
}
