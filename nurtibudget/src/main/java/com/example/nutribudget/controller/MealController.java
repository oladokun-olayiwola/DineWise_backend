package com.example.nutribudget.controller;

// If MealService is in a different package, update the import to the correct package, e.g.:
// import com.example.nurtibudget.services.MealService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nutribudget.model.Meal;
import com.example.nutribudget.service.MealService;

@RestController
@RequestMapping("/api")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/recommendations")
    public List<Meal> getMealRecommendations(@RequestParam int budget) {
        return mealService.getMealsWithinBudget(budget);
    }
}
