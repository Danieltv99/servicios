package com.co.daniel.tallerDos.service;

import com.co.daniel.tallerDos.model.GroceryItem;
import com.co.daniel.tallerDos.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service


public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<GroceryItem> getAll() {
        return itemRepository.findAll();
    }

    public GroceryItem insert(GroceryItem groceryItem) {
        return itemRepository.save(groceryItem);
    }

    public String update(GroceryItem groceryItem) {
        Optional<GroceryItem> existingItem = itemRepository.findById(groceryItem.getId());
        if (existingItem.isPresent()) {
            GroceryItem updatedItem = existingItem.get();
            updatedItem.setName(groceryItem.getName());
            updatedItem.setQuantity(groceryItem.getQuantity());
            updatedItem.setCategory(groceryItem.getCategory());
            itemRepository.save(updatedItem);
            return "---ITEM ACTUALIZADO---\n" + updatedItem.toString();
        } else {
            return "---ITEM NO ENCONTRADO---";
        }
    }

    public String delete(String id) {
        Optional<GroceryItem> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            itemRepository.deleteById(id);
            return "---ITEM ELIMINADO---";
        } else {
            return "---ITEM NO ENCONTRADO---";
        }
    }

    public String updateData(String id, GroceryItem groceryItem) {
        Optional<GroceryItem> existingItem = itemRepository.findById(id);
        if (existingItem.isPresent()) {
            GroceryItem itemToUpdate = existingItem.get();
            if (groceryItem.getName() != null) {
                itemToUpdate.setName(groceryItem.getName());
            }
            if (groceryItem.getCategory() != null) {
                itemToUpdate.setCategory(groceryItem.getCategory());
            }
            itemRepository.save(itemToUpdate);
            return "---ITEM ACTUALIZADO---\n" + itemToUpdate.toString();
        } else {
            return "---ITEM NO ENCONTRADO---";
        }
    }

    // Nuevo método: Buscar por nombre
    public List<GroceryItem> findByName(String name) {
        return itemRepository.findByName(name);
    }

    // Nuevo método: Buscar por categoría
    public List<GroceryItem> findByCategory(String category) {
        return itemRepository.findByCategory(category);
    }

    // Nuevo método: Buscar por cantidad mayor que
    public List<GroceryItem> findByQuantityGreaterThan(int quantity) {
        return itemRepository.findByQuantityGreaterThan(quantity);
    }



}
