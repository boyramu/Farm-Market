package com.ecommerce.farmmarket.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.farmmarket.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>
{
   Customer findByEmail(String email);
}
