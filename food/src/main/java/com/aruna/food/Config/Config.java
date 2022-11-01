package com.aruna.food.Config;

import com.aruna.food.Repositiry.CustomerRepository;
import com.aruna.food.Repositiry.ItemRepository;
import com.aruna.food.Repositiry.RestaurantRepository;
import com.aruna.food.dao.Customer;
import com.aruna.food.dao.Item;
import com.aruna.food.dao.Restaurant;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class Config {


    //Enter a bunch of dummy Customers for Ease of Checking
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository repository, ItemRepository itemRepository){
        return args -> {
            Customer aruna = new Customer("Aruna", "aw@example.com", 24, LocalDate.of(1998, Month.OCTOBER,18));
            Customer wasantha = new Customer("Wasantha", "wasantha@example.com", 20, LocalDate.of(200, Month.NOVEMBER,15));
            Customer kumara = new Customer("Kumara", "kumara@example.com", 27, LocalDate.of(1995, Month.DECEMBER,19));
            Customer joe = new Customer("Joe", "joe@example.com",21, LocalDate.of(1999, Month.JANUARY,10));

            Item foodItem1 = new Item("FoodItem01", 44.5F);
            Item foodItem2 = new Item("FoodItem02", 54.5F);
            Item foodItem3 = new Item("FoodItem03", 64.5F);
            Item foodItem4 = new Item("FoodItem04", 74.5F);


            repository.saveAll(List.of(aruna,wasantha,kumara,joe));
            itemRepository.saveAll(List.of(foodItem1,foodItem2,foodItem3,foodItem4));

        };


    }
}