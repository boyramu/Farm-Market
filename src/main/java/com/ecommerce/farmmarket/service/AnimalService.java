package com.ecommerce.farmmarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.farmmarket.Repository.AnimalRepo;
import com.ecommerce.farmmarket.model.Animal;

@Service
public class AnimalService 
{
	@Autowired
	private AnimalRepo ar;
  public Animal saveAnimal(Animal animal)
  {
	  return ar.save(animal);
  }
  public List<Animal> getAnimals()
  {
	  return ar.findAll();
  }
  public Animal getAnimal(Integer id)
  {
	  return ar.findById(id).orElse(null);
  }
}
