package com.example.foodconnect
        .service;

import com.example.foodconnect.entity.Afssc;
import com.example.foodconnect.repository.AfsscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfsscService {

    @Autowired
    private AfsscRepository afsscRepository;

    // Get all afssc records
    public List<Afssc> getAllAfssc() {
        return afsscRepository.findAll();
    }

    // Get afssc by ID
    public Optional<Afssc> getAfsscById(Long id) {
        return afsscRepository.findById(id);
    }

    // Save afssc record
    public Afssc saveAfssc(Afssc afssc) {
        return afsscRepository.save(afssc);
    }

    // Delete afssc record by ID
    public void deleteAfssc(Long id) {
        afsscRepository.deleteById(id);
    }
}
