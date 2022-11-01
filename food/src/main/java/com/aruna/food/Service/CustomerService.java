package com.aruna.food.Service;

import com.aruna.food.Repositiry.CustomerRepository;
import com.aruna.food.dao.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;


    public Customer getCustomerById(Long customerId) {
        return   customerRepository.findById(customerId).get();

    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
