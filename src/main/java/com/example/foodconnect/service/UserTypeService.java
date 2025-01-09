package com.example.foodconnect.service;

import com.example.foodconnect.entity.UserType;
import com.example.foodconnect.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTypeService {

    @Autowired
    private UserTypeRepository userTypeRepository;

    public List<UserType> getAllUserTypes() {
        return userTypeRepository.findAll();
    }

    public UserType getUserTypeById(Long id) {
        return userTypeRepository.findById(id).orElse(null);
    }

    public UserType createUserType(UserType userType) {
        return userTypeRepository.save(userType);
    }

    public UserType updateUserType(Long id, UserType updatedUserType) {
        UserType existingUserType = userTypeRepository.findById(id).orElse(null);
        if (existingUserType != null) {
            existingUserType.setUserType(updatedUserType.getUserType());
            return userTypeRepository.save(existingUserType);
        }
        return null;
    }

    public void deleteUserType(Long id) {
        userTypeRepository.deleteById(id);
    }
}
