package com.ecommerce.farmmarket.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.farmmarket.model.Animal;

public interface AnimalRepo extends JpaRepository<Animal, Integer>
{

}
