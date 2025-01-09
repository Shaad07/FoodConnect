package com.example.foodconnect.service;

import com.example.foodconnect.entity.Country;
import com.example.foodconnect.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(Long id, Country updatedCountry) {
        Country existingCountry = countryRepository.findById(id).orElse(null);
        if (existingCountry != null) {
            existingCountry.setName(updatedCountry.getName());
            return countryRepository.save(existingCountry);
        }
        return null;
    }

    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
}
