package com.example.foodconnect.service;

import com.example.foodconnect.entity.Donor;
import com.example.foodconnect.repository.DonorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DonorService {

    @Autowired
    private DonorRepository donorRepository;

    public List<Donor> getAllDonors() {
        return donorRepository.findAll();
    }

    public Donor getDonorById(Long id) {
        Optional<Donor> donor = donorRepository.findById(id);
        return donor.orElseThrow(() -> new RuntimeException("Donor not found with ID: " + id));
    }

    public Donor createDonor(Donor donor) {
        return donorRepository.save(donor);
    }

    public Donor updateDonor(Long id, Donor updatedDonor) {
        Donor existingDonor = getDonorById(id);
        existingDonor.setUserId(updatedDonor.getUserId());
        existingDonor.setDonorName(updatedDonor.getDonorName());
        existingDonor.setDonorType(updatedDonor.getDonorType());
        existingDonor.setContactEmail(updatedDonor.getContactEmail());
        existingDonor.setContactPhone(updatedDonor.getContactPhone());
        return donorRepository.save(existingDonor);
    }

    public void deleteDonor(Long id) {
        Donor donor = getDonorById(id);
        donorRepository.delete(donor);
    }
}
