package com.ecommerce.farmmarket.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.farmmarket.model.Cart;
@Repository
public interface CartRepo extends JpaRepository<Cart, Integer>
{
	List<Cart> findByCustomerCid(int cid);
}
