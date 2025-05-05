package com.example.dinewise.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dinewise.model.Meal;
import com.example.dinewise.repository.MealRepository;

import java.util.Optional;
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

    public Meal saveMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    public Meal updateMealPartial(int id, Meal updates) {
        Optional<Meal> optionalMeal = mealRepository.findById(id);
        if (optionalMeal.isEmpty()) {
            return null;
        }

        Meal meal = optionalMeal.get();

        if (updates.getPrice() != 0) {
            meal.setPrice(updates.getPrice());
        }
        if (updates.getHealthScore() != null) {
            meal.setHealthScore(updates.getHealthScore());
        }
        if (updates.getImageUrl() != null) {
            meal.setImageUrl(updates.getImageUrl());
        }
        if (updates.getFoodCombination() != null) {
            meal.setFoodCombination(updates.getFoodCombination());
        }
        return mealRepository.save(meal);
    }    
}
