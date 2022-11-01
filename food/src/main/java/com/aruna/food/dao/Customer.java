package com.aruna.food.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "customer")
@Table(name = "customer_Table")
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    @Column(
            name = "customerId",
            updatable = false
    )
    private Long customerId;

    @Column(
            name = "name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String name;
    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @Column(
            name = "age"
    )
    private int age;

    @Column(
            name = "dob"
    )
    private LocalDate dob;




    //Relationships
    //Many-to-Many Relationship wth Item
    @JsonIgnore
    @ManyToMany(mappedBy = "customersOrders")
    private Set<Item> orderedItems = new HashSet<>();




    //Constructors
    public Customer(Long customerId, String name, String email, int age, LocalDate dob) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    public Customer(String name, String email, int age, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    public Customer() {

    }


    //Getters and Setters
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Set<Item> getOrderedItems() {
        return orderedItems;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", orderedItems=" + orderedItems +
                '}';
    }
}
