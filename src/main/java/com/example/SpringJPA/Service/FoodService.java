package com.example.SpringJPA.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.example.SpringJPA.Model.Food;
import com.example.SpringJPA.Repository.FoodRepository;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }


    public ResponseEntity<Food> createFood(Food food) {
        Food savedFood = foodRepository.save(food);
        return ResponseEntity.ok(savedFood);
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Optional<Food> getFood(Long id) {
        return foodRepository.findById(id);
    }

    public Optional<Food> updateFood(Long id, Food food) {
        return foodRepository.findById(id).map(existing -> {
            existing.setFoodname(food.getFoodname());
            existing.setPrice(food.getPrice());
            existing.setAvailable(food.isAvailable());
            return foodRepository.save(existing);
        });
    }

    public boolean deleteFood(Long id) {
        if (!foodRepository.existsById(id)) {
            return false;
        }
        foodRepository.deleteById(id);
        return true;
    }
}
