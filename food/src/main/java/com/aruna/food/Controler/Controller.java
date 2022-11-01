package com.aruna.food.Controler;

import com.aruna.food.Service.CustomerService;
import com.aruna.food.Service.ItemService;
import com.aruna.food.Service.RestaurantService;
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

    private final CustomerService customerService;
    private final RestaurantService restaurantService;
    private final ItemService itemService;

    @Autowired
    public Controller(CustomerService customerService, RestaurantService restaurantService, ItemService itemService) {
        this.customerService = customerService;
        this.restaurantService = restaurantService;
        this.itemService = itemService;
    }


    //GetMapping
    //Get the List Of Restaurants
    // http://localhost:8080/api/v1/RestaurantList
    @GetMapping("RestaurantList")
    public List<Restaurant> findRestaurantList(){
        return restaurantService.getAllRestaurants();
    }


    //Get the List Of Items in the Restaurant
    // http://localhost:8080/api/v1/Restaurant/{restaurantId}
    @GetMapping("Restaurant/{restaurantId}")
    public Set<Item> getRestaurantItemList( @PathVariable Long restaurantId){
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        Set<Item> restaurantItems = restaurant.getItems();
        return restaurantItems;
    }


    //Note : Item ID is unique no need the Restaurant to select the Item
    //Place the Order with the Item Number and Customer Number
    // http://localhost:8080/api/v1/items/{itemId}/customer/{customerId}
    @PutMapping("items/{itemId}/customer/{customerId}")
    public Item placeOrder(
            @PathVariable Long itemId,
            @PathVariable Long customerId
    ){

       System.out.println(itemId + customerId);
        Set<Customer> customerSet = null;

        Item item = itemService.getItemById(itemId);
        Customer customer = customerService.getCustomerById(customerId);

       //System.out.println("Item : " + item.toString() + "\nCustomer : " + customer.toString());

        customerSet = item.getCustomersOrders();
        customerSet.add(customer);
        item.setCustomersOrders(customerSet);


        return itemService.placeOrder(item);
    }




    //Other EndPoints

    //Assign Items To Restaurants
    @PutMapping("items/{itemId}/restaurant/{restaurantID}")
    public Item  enterResautrantItem(
            @PathVariable Long itemId,
            @PathVariable Long restaurantID
    ){

        Item item = itemService.getItemById(itemId);
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantID);
        item.assignResturant(restaurant);
        return itemService.placeOrder(item);
    }

    //Insert a List of Restaurants
    @PostMapping("inputListOfRestaurant")
    public List<Restaurant> addListRestaurant(@RequestBody List<Restaurant> restaurants){
        return restaurantService.insertListOfRestaurants(restaurants);
    }

    //Insert a List of Items with Restaurants
    @PostMapping("inputListOfItemsWithRestaurants")
    public List<Item> addAListOfItemsWithRestaurants(@RequestBody List<Item> itemsWithRestaurants){
        return itemService.insertItemsWithRestaurants(itemsWithRestaurants);
    }



    //Get a List of All the Customers
    @GetMapping("getAllCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    //Insert a List of Customers
    @PostMapping("inputListOfCustomers")
    public List<Customer> addListCustomers(@RequestBody List<Customer> customers){
        return customerService.insertListOfCustomers(customers);
    }


    //Get a List of All the Items
    @GetMapping("getAllItems")
    public List<Item> getAllItems(){
        return itemService.getAllItems();
    }



}
