package com.aruna.food.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "item")
@Table(name = "item_Table")
public class Item {

    @Id
    @SequenceGenerator(
            name = "item_sequence",
            sequenceName = "item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "item_sequence"
    )
    @Column(
            name = "itemId",
            updatable = false
    )
    private Long itemId;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;

    @Column(
            name = "price",
            nullable = false
    )
    private float price;

    //Relationships
    //Many-to-Many Relationship wth Customer
    @ManyToMany
    @JoinTable(
            name = "orders_Table",
            joinColumns = @JoinColumn( name = "itemId"),
            inverseJoinColumns = @JoinColumn( name = "customerId")
    )
    private Set<Customer> customersOrders = new HashSet<>();

    //Many to One Restaurant

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "restaurant_Id",referencedColumnName = "restaurantId")
    private Restaurant restaurant;



    //Constructors
    public Item(Long itemId, String name, float price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }

    public Item(String name, float price, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.restaurant = restaurant;
    }

    public Item() {

    }


    //Getters and Setters
    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<Customer> getCustomersOrders() {
        return customersOrders;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setCustomersOrders(Set<Customer> customersOrders) {
        this.customersOrders = customersOrders;
    }

    public void assignResturant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", customersOrders=" + customersOrders +
                '}';
    }

}
