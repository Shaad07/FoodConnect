package com.example.foodconnect.controller;

import com.example.foodconnect.entity.FoodRequest;
import com.example.foodconnect.service.FoodRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food-requests")
public class FoodRequestController {

    @Autowired
    private FoodRequestService foodRequestService;

    @GetMapping
    public List<FoodRequest> getAllFoodRequests() {
        return foodRequestService.getAllFoodRequests();
    }

    @GetMapping("/{id}")
    public FoodRequest getFoodRequestById(@PathVariable Long id) {
        return foodRequestService.getFoodRequestById(id);
    }

    @PostMapping
    public FoodRequest createFoodRequest(@RequestBody FoodRequest foodRequest) {
        return foodRequestService.createFoodRequest(foodRequest);
    }

    @PutMapping("/{id}")
    public FoodRequest updateFoodRequest(@PathVariable Long id, @RequestBody FoodRequest foodRequest) {
        return foodRequestService.updateFoodRequest(id, foodRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteFoodRequest(@PathVariable Long id) {
        foodRequestService.deleteFoodRequest(id);
    }
}
