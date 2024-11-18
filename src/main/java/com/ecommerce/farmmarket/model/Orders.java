package com.ecommerce.farmmarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "orders") // Ensure the table name is correct if it is different
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int oid;                // Order ID (auto-generated)
    
    @ManyToOne
    @JoinColumn(name = "cid", nullable = false) // Foreign key for Customer ID
    private Customer customer;      // Reference to Customer entity
    
    @ManyToOne
    @JoinColumn(name = "aid", nullable = false) // Foreign key for Animal ID
    private Animal animal;          // Reference to Animal entity

    // Default constructor
    public Orders() {
    }

    // Parameterized constructor
    public Orders(Customer customer, Animal animal) {
        this.customer = customer;
        this.animal = animal;
    }

    // New constructor for OrderController
    public Orders(int cid, int aid) {
        this.customer = new Customer(); // Initialize customer and animal if you have their ids
        this.customer.setCid(cid); // Assuming `setCid` method exists in `Customer`
        this.animal = new Animal(); // Similarly for Animal
        this.animal.setId(aid); // Assuming `setId` method exists in `Animal`
    }

    // Getters and Setters
    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
