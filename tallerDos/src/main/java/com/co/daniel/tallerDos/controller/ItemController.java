package com.co.daniel.tallerDos.controller;


import com.co.daniel.tallerDos.model.GroceryItem;
import com.co.daniel.tallerDos.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("item")

public class ItemController {

    @Autowired
    private ItemService itemService;

    // Método de ejemplo para verbo GET
    @GetMapping("/getAll")
    public List<GroceryItem> getAll(){
        return itemService.getAll();
    }

    // Método de ejemplo para verbo POST
    @PostMapping("/insert")
    public GroceryItem insert(@RequestBody GroceryItem groceryItem){
        return itemService.insert(groceryItem);
    }

    // Método de ejemplo para verbo UPDATE
    @PutMapping("/update")
    public String update(@RequestBody GroceryItem groceryItem){
        return itemService.update(groceryItem);
    }

    // Método de ejemplo para verbo DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable("id") String id) {
        return itemService.delete(id);
    }

    // Método de ejemplo para verbo PATCH
    @PatchMapping("/updateData/{id}")
    public String updateData(@PathVariable String id, @RequestBody GroceryItem groceryItem){
        return itemService.updateData(id, groceryItem);
    }

    // Nuevo: Buscar por nombre
    @GetMapping("/findByName/{name}")
    public List<GroceryItem> findByName(@PathVariable String name) {
        return itemService.findByName(name);
    }

    // Nuevo: Buscar por categoría
    @GetMapping("/findByCategory/{category}")
    public List<GroceryItem> findByCategory(@PathVariable String category) {
        return itemService.findByCategory(category);
    }

    // Nuevo: Buscar por cantidad mayor que
    @GetMapping("/findByQuantityGreaterThan/{quantity}")
    public List<GroceryItem> findByQuantityGreaterThan(@PathVariable int quantity) {
        return itemService.findByQuantityGreaterThan(quantity);
    }




}
