package com.ecommerce.farmmarket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.farmmarket.model.Orders;

public interface OrderRepo extends JpaRepository<Orders, Integer>
{ 
	List<Orders> findByCustomerCid(int cid);

}
