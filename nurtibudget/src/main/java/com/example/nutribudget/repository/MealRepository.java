package com.example.nutribudget.repository;

import com.example.nutribudget.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
    List<Meal> findByPriceLessThanEqual(int price);
}
