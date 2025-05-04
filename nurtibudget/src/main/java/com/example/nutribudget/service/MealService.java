package com.example.nutribudget.service;

import com.example.nutribudget.model.Meal;
import com.example.nutribudget.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public List<Meal> getMealsWithinBudget(int budget) {
        return mealRepository.findByPriceLessThanEqual(budget);
    }

    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }
}
