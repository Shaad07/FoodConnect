package com.example.foodconnect.service;

import com.example.foodconnect.entity.City;
import com.example.foodconnect.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    // Fetch all cities
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // Fetch city by ID
    public City getCityById(Long id) {
        Optional<City> cityOptional = cityRepository.findById(id);
        return cityOptional.orElse(null);
    }
}
