package com.example.foodconnect.service;

import com.example.foodconnect.entity.Volunteer;
import com.example.foodconnect.repository.VolunteerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;

    public List<Volunteer> getAllVolunteers() {
        return volunteerRepository.findAll();
    }

    public Volunteer getVolunteerById(Long id) {
        return volunteerRepository.findById(id).orElse(null);
    }

    public Volunteer createVolunteer(Volunteer volunteer) {
        return volunteerRepository.save(volunteer);
    }

    public Volunteer updateVolunteer(Long id, Volunteer updatedVolunteer) {
        Volunteer existingVolunteer = volunteerRepository.findById(id).orElse(null);
        if (existingVolunteer != null) {
            existingVolunteer.setUserId(updatedVolunteer.getUserId());
            existingVolunteer.setAvailabilityStatus(updatedVolunteer.getAvailabilityStatus());
            existingVolunteer.setAssignedTaskId(updatedVolunteer.getAssignedTaskId());
            return volunteerRepository.save(existingVolunteer);
        }
        return null;
    }

    public void deleteVolunteer(Long id) {
        volunteerRepository.deleteById(id);
    }
}
