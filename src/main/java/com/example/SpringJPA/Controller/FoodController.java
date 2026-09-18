package com.example.SpringJPA.Controller;

import com.example.SpringJPA.Service.FoodService;
import com.example.SpringJPA.Model.Food;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping ("/api/order") 
public class FoodController {
    
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @RequestMapping("/test")
    public String test() {
        return "Server is running";
    }
     
      
    @PostMapping("/addFood")
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        return foodService.createFood(food);
    }

    @GetMapping("/foods")
    public List<Food> getFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/foods/{id}")
    public ResponseEntity<Food> getFood(@PathVariable Long id) {
        return foodService.getFood(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/foods/{id}")
    public ResponseEntity<Food> updateFood(@PathVariable Long id, @RequestBody Food food) {
        return foodService.updateFood(id, food)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/foods/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable("id") Long id) {
        return foodService.deleteFood(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
