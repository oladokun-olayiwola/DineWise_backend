package com.example.nutribudget.service;

import com.example.nutribudget.model.Meal;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

@Service
public class MealService {

    private final List<Meal> meals;

    public MealService() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Meal> loadedMeals;

        try (InputStream inputStream = getClass().getResourceAsStream("/data/meals.json")) {
            if (inputStream == null) {
                throw new IllegalStateException("meals.json file not found in resources!");
            }
            loadedMeals = objectMapper.readValue(inputStream, new TypeReference<>() {});
        } catch (IOException e) {
            System.err.println("Failed to load meals.json: " + e.getMessage());
            loadedMeals = Collections.emptyList();
        }

        this.meals = loadedMeals;
    }

    public List<Meal> getMealsWithinBudget(int budget) {
        return meals.stream()
                .filter(meal -> meal.getPrice() <= budget)
                .toList();
    }

    public List<Meal> getAllMeals() {
        return meals;
    }
}