package com.ecommerce.farmmarket.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.farmmarket.model.Animal;
import com.ecommerce.farmmarket.service.AnimalService;
@Controller
public class AnimalData
{
	@Autowired
	private AnimalService as;
 @RequestMapping("/welcome")
 public String dispalyHome()
 {
	 return "AnimalHome";
 }
	@GetMapping("/animalDetails")
	public ModelAndView getAnimalDetails(@RequestParam("id") Integer id,
			@RequestParam("customerId") Integer cid)
	{ 
		ModelAndView mv=new ModelAndView();
	    Animal animal=as.getAnimal(id);
	    if(animal==null)
	    {
	    	mv.addObject("res","not found");
	    	mv.setViewName("result");
	    }
	    else
	    {
	    	mv.addObject("animal",animal);
	    	mv.addObject("customerid",cid);
	    	mv.setViewName("AnimalDetails");
	    }
	    return mv;
	    
	}
}
