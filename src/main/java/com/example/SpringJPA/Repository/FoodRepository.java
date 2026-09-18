package com.example.SpringJPA.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringJPA.Model.Food;




@Repository
public interface FoodRepository extends JpaRepository<Food,Long>{
     
}
