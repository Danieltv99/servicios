package com.co.daniel.tallerDos.repository;

import com.co.daniel.tallerDos.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<GroceryItem, String> {
    // Buscar elementos por nombre
    List<GroceryItem> findByName(String name);

    // Buscar elementos por categoría
    List<GroceryItem> findByCategory(String category);

    // Buscar elementos por cantidad mayor que un valor dado
    List<GroceryItem> findByQuantityGreaterThan(int quantity);
}

