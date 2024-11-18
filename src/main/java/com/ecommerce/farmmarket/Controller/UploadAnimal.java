package com.ecommerce.farmmarket.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.farmmarket.model.Animal;
import com.ecommerce.farmmarket.service.AnimalService;

@Controller
public class UploadAnimal {
	@Autowired
	private AnimalService as;
	@RequestMapping("/upload")
    public String showUploadAnimalPage() {
        return "uploadAnimal"; // No need to specify the full path, just the name
    }

    @RequestMapping("/uploadAnimal")
    public ModelAndView uploadAnimal(
            @RequestParam("name") String name,
            @RequestParam("breed") String breed,
            @RequestParam("age") Integer age,
            @RequestParam("price") Double price,
            @RequestParam("color") String color,
            @RequestParam("contact") String contact,
            @RequestParam("milkYield") Float milkYield,
            @RequestParam("status") String status,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile imageFile) throws IOException 
    {
    	ModelAndView mv=new ModelAndView();
    	 byte[] imageBytes = imageFile.getBytes();

        // Create a new Animal object
        Animal animal = new Animal(name,breed,age,price,color,contact,milkYield,imageBytes,status,description);
       System.out.println(animal); 
       if(as.saveAnimal(animal)!=null)
       {
    	mv.addObject("res","uploaded successfully");   
       }
       else
       {
    	   mv.addObject("res"," not uploaded ");
       }
        mv.setViewName("result");
        return mv;
        
    }
}
