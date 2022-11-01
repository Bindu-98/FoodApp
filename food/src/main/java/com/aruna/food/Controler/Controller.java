package com.aruna.food.Controler;

import com.aruna.food.Repositiry.CustomerRepository;
import com.aruna.food.Repositiry.ItemRepository;
import com.aruna.food.Repositiry.RestaurantRepository;
import com.aruna.food.dao.Customer;
import com.aruna.food.dao.Item;
import com.aruna.food.dao.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "api/v1")
public class Controller {

    private final CustomerRepository customerRepository;
    private final ItemRepository itemRepository;
    private final RestaurantRepository restaurantRepository;


    @Autowired
    public Controller(CustomerRepository customerRepository, ItemRepository itemRepository, RestaurantRepository restaurantRepository) {
        this.customerRepository = customerRepository;
        this.itemRepository = itemRepository;
        this.restaurantRepository = restaurantRepository;
    }




    @PutMapping("items/{itemId}/customer/{customerId}")
    public Item placeOrder(
            @PathVariable Long itemId,
            @PathVariable Long customerId
    ){
       System.out.println(itemId + customerId);
        Set<Customer> customerSet = null;

        Item item = itemRepository.findById(itemId).get();
        Customer customer = customerRepository.findById(customerId).get();

       //System.out.println("Item : " + item.toString() + "\nCustomer : " + customer.toString());

        customerSet = item.getCustomersOrders();
        customerSet.add(customer);
        item.setCustomersOrders(customerSet);


        return itemRepository.save(item);
    }


    @PostMapping("inputResturantList")
    public Restaurant additems(@RequestBody Restaurant restaurant){
        return restaurantRepository.save(restaurant);
    }

    @GetMapping("findRestaurantList")
    public List<Restaurant> findRestaurantList(){
        return restaurantRepository.findAll();
    }



    @GetMapping("allCustomers")
    public List<Customer> getCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("allItems")
    public List<Item> getItem(){
        return itemRepository.findAll();
    }



}
