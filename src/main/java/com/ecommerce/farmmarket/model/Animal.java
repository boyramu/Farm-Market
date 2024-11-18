package com.ecommerce.farmmarket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aid")
    private Integer id;

    private String name;
    private String breed;
    private Integer age;
    private Double price;
    private String color;
    private String contact;

    @Column(name = "milk_yield")
    private Float milkYield;  // Milk yield in liters/day

    @Lob
    private byte[] image;     // Image stored as a byte array

    private String status;    // Status of the animal (e.g., "GIVING_MILK", "PREGNANT", "NOT_APPLICABLE")
    
    @Column(columnDefinition = "TEXT")
    private String description;

    // Constructors
    public Animal() {
    }

    public Animal(String name, String breed, Integer age, Double price, String color, String contact, Float milkYield,
                  byte[] image, String status, String description) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.price = price;
        this.color = color;
        this.contact = contact;
        this.milkYield = milkYield;
        this.image = image;
        this.status = status;
        this.description = description;
    }

    public Animal(Integer id, String name, String breed, Integer age, Double price, String color, String contact,
                  Float milkYield, byte[] image, String status, String description) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.price = price;
        this.color = color;
        this.contact = contact;
        this.milkYield = milkYield;
        this.image = image;
        this.status = status;
        this.description = description;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBreed() { return breed; }
    public void setBreed(String breed) { this.breed = breed; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public Float getMilkYield() { return milkYield; }
    public void setMilkYield(Float milkYield) { this.milkYield = milkYield; }

    public byte[] getImage() { return image; }
    public void setImage(byte[] image) { this.image = image; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", contact='" + contact + '\'' +
                ", milkYield=" + milkYield +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
