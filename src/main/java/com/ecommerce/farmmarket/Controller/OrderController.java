package com.ecommerce.farmmarket.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecommerce.farmmarket.model.Animal;
import com.ecommerce.farmmarket.model.Customer;
import com.ecommerce.farmmarket.model.Orders;
import com.ecommerce.farmmarket.service.AnimalService;
import com.ecommerce.farmmarket.service.CartService;
import com.ecommerce.farmmarket.service.CustomerService;
import com.ecommerce.farmmarket.service.MailService;
import com.ecommerce.farmmarket.service.OrderService;

import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired 
    private AnimalService animalService;
    
    @Autowired
    private MailService mailService;

    @Autowired
    private CartService cartService;

    @RequestMapping("/order")
    public ModelAndView orderAnimal(
        @RequestParam("animalId") int animalId,
        @RequestParam("customerId") int customerId,
        HttpSession session) throws MessagingException {

        ModelAndView mv = new ModelAndView();
        
        // Create and save a new order
        Orders order = new Orders(customerId, animalId);
        Animal animal = animalService.getAnimal(animalId);
        Customer customer = customerService.getCustomer(customerId);
        Orders savedOrder = orderService.saveOrder(order);

        if (savedOrder == null) {
            mv.addObject("res", "Order failed, please try again.");
            mv.setViewName("AnimalDetails");
            return mv;
        }

        // Prepare email details
        String recipientEmail = customer.getEmail();
        String subject = "Order Details from Farm Market";
        String emailContent = "<h3>Order ID: " + savedOrder.getOid() + "</h3>" +
                              "<p><b>Animal Details:</b><br>" +
                              "Name: " + animal.getName() + "<br>" +
                              "Breed: " + animal.getBreed() + "<br>" +
                              "Color: " + animal.getColor() + "<br>" +
                              "Age: " + animal.getAge() + " years<br>" +
                              "Status: " + animal.getStatus() + "<br>" +
                              "Price: " + animal.getPrice() + "<br>" +
                              "Delivery Address: " + customer.getAddress() + "<br>" +
                              "</p>";
        byte[] animalImage = animal.getImage();
        
        // Send email with image
        mailService.sendEmailWithImage(recipientEmail, subject, emailContent, animalImage, animal.getName() + ".jpg");

        // Populate the ModelAndView for success page
        List<Orders> customerOrders = orderService.getOrders(customerId);
        mv.addObject("orders", customerOrders);
        mv.addObject("cartItems", cartService.getCartItems(customerId));
        mv.addObject("res", "Order successful, continue shopping!");
        session.setAttribute("res", "Order successful, continue shopping!");
        mv.addObject("customer", customer);
        mv.addObject("animals", animalService.getAnimals());
        mv.addObject("customerId", customer.getCid());
        mv.setViewName("AnimalHome");

        return mv;
    }

    @RequestMapping("/getorders")
    public ModelAndView getOrders(@RequestParam("cid") int customerId) {
        ModelAndView mv = new ModelAndView();
        
        // Fetch orders for the customer
        List<Orders> orders = orderService.getOrders(customerId);
        List<Animal> animals = new ArrayList<>();

        if (orders == null || orders.isEmpty()) {
            mv.addObject("res", "No orders found.");
        } else {
            for (Orders order : orders) {
                animals.add(order.getAnimal());
            }
        }

        mv.addObject("animals", animals);
        mv.addObject("cartItems", cartService.getCartItems(customerId));
        mv.addObject("customer", customerService.getCustomer(customerId));
        mv.setViewName("CustomerOrders");
        
        return mv;
    }
}
