package com.aruna.food.Service;

import com.aruna.food.Repositiry.RestaurantRepository;
import com.aruna.food.dao.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    //Get a List of all the Restaurants
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.findById(restaurantId).get();
    }

    public Restaurant insertRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public List<Restaurant> insertListOfRestaurants(List<Restaurant> restaurants) {
        return restaurantRepository.saveAll(restaurants);
    }
}
