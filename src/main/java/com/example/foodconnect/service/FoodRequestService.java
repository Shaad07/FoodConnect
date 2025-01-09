package com.example.foodconnect.service;

import com.example.foodconnect.entity.FoodRequest;
import com.example.foodconnect.repository.FoodRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodRequestService {

    @Autowired
    private FoodRequestRepository foodRequestRepository;

    public List<FoodRequest> getAllFoodRequests() {
        return foodRequestRepository.findAll();
    }

    public FoodRequest getFoodRequestById(Long id) {
        Optional<FoodRequest> foodRequest = foodRequestRepository.findById(id);
        return foodRequest.orElseThrow(() -> new RuntimeException("Food Request not found with ID: " + id));
    }

    public FoodRequest createFoodRequest(FoodRequest foodRequest) {
        return foodRequestRepository.save(foodRequest);
    }

    public FoodRequest updateFoodRequest(Long id, FoodRequest updatedFoodRequest) {
        FoodRequest existingFoodRequest = getFoodRequestById(id);
        existingFoodRequest.setAfsscId(updatedFoodRequest.getAfsscId());
        existingFoodRequest.setVolunteerId(updatedFoodRequest.getVolunteerId());
        existingFoodRequest.setRequestStatus(updatedFoodRequest.getRequestStatus());
        existingFoodRequest.setRequestTime(updatedFoodRequest.getRequestTime());
        existingFoodRequest.setPickupTime(updatedFoodRequest.getPickupTime());
        existingFoodRequest.setDropLocation(updatedFoodRequest.getDropLocation());
        return foodRequestRepository.save(existingFoodRequest);
    }

    public void deleteFoodRequest(Long id) {
        FoodRequest foodRequest = getFoodRequestById(id);
        foodRequestRepository.delete(foodRequest);
    }
}
