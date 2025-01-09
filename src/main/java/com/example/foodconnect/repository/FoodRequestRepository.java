package com.example.foodconnect.repository;

import com.example.foodconnect.entity.FoodRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRequestRepository extends JpaRepository<FoodRequest, Long> {
}
