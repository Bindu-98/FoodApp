package com.aruna.food.Service;

import com.aruna.food.Repositiry.ItemRepository;
import com.aruna.food.dao.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId).get();
    }

    public Item placeOrder(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public List<Item> insertItemsWithRestaurants(List<Item> itemsWithRestaurants) {
        return itemRepository.saveAll(itemsWithRestaurants);
    }
}
