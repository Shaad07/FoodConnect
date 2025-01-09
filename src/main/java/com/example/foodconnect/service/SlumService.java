package com.example.foodconnect.service;

import com.example.foodconnect.entity.Slum;
import com.example.foodconnect.repository.SlumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlumService {

    @Autowired
    private SlumRepository slumRepository;

    public List<Slum> getAllSlums() {
        return slumRepository.findAll();
    }

    public Slum getSlumById(Long id) {
        Optional<Slum> slum = slumRepository.findById(id);
        return slum.orElseThrow(() -> new RuntimeException("Slum not found with ID: " + id));
    }

    public Slum createSlum(Slum slum) {
        return slumRepository.save(slum);
    }

    public Slum updateSlum(Long id, Slum updatedSlum) {
        Slum existingSlum = getSlumById(id);
        existingSlum.setName(updatedSlum.getName());
        existingSlum.setCityId(updatedSlum.getCityId());
        existingSlum.setPopulation(updatedSlum.getPopulation());
        return slumRepository.save(existingSlum);
    }

    public void deleteSlum(Long id) {
        Slum slum = getSlumById(id);
        slumRepository.delete(slum);
    }
}
