package com.aruna.food.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "restaurant")
@Table(name = "restaurant_Table")
public class Restaurant {
    @Id
    @SequenceGenerator(
            name = "restaurant_sequence",
            sequenceName = "restaurant_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "restaurant_sequence"
    )
    @Column(
            name = "restaurantId",
            updatable = false
    )
    private Long restaurantId;


    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String Name;

    @Column(
            name = "address",
            columnDefinition = "TEXT"
    )
    private String address;







    //Relationships
    //One to Many with ITEM
    @JsonIgnore
    @OneToMany(mappedBy = "restaurant")
    private Set<Item> items = new HashSet<>();









    //Constructors
    public Restaurant(Long restaurantId, String name, String address) {
        this.restaurantId = restaurantId;
        Name = name;
        this.address = address;
    }

    public Restaurant(String name, String address, Set<Item> items) {
        Name = name;
        this.address = address;
        this.items = items;
    }

    public Restaurant(String name, String address) {
        Name = name;
        this.address = address;
    }

    public Restaurant() {
    }




    //Getters and Setters
    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Item> getItems() {
        return items;
    }
}
