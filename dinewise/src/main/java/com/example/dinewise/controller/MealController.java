package com.example.dinewise.controller;

// If MealService is in a different package, update the import to the correct package, e.g.:
// import com.example.nurtibudget.services.MealService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dinewise.model.Meal;
import com.example.dinewise.repository.MealRepository;
import com.example.dinewise.service.MealService;

@RestController
@RequestMapping("/api")
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private MealRepository mealRepository;

    @GetMapping("/recommendations")
    public List<Meal> getMealRecommendations(@RequestParam int budget) {
        return mealService.getMealsWithinBudget(budget);
    }

    @GetMapping("/all-meals")
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @PostMapping("/add-meal")
    public ResponseEntity<Meal> addMeal(@RequestBody Meal newMeal) {
        Meal savedMeal = mealService.saveMeal(newMeal);
        return ResponseEntity.ok(savedMeal);
    }

    @PatchMapping("/update-meal/{id}")
    public ResponseEntity<Meal> updateMealPartially(@PathVariable int id, @RequestBody Meal updatedFields) {
        Meal updatedMeal = mealService.updateMealPartial(id, updatedFields);
        if (updatedMeal != null) {
            return ResponseEntity.ok(updatedMeal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/meals/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable int id) {
        Optional<Meal> meal = mealRepository.findById(id);
        return meal.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/meals/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable int id) {
        if (mealRepository.existsById(id)) {
            mealRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
