package com.example.dinewise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dinewise.model.Meal;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {
    List<Meal> findByPriceLessThanEqual(int budget);

    List<Meal> findAll();
}
