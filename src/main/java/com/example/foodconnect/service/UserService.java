package com.example.foodconnect.service;

import com.example.foodconnect.dto.UserDTO;
import com.example.foodconnect.entity.User;
import com.example.foodconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PasswordService passwordService;


    public User signup(UserDTO userDTO) {
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists: " + userDTO.getEmail());
        }
        return createUserFromDTO(userDTO);
    }

    public User createUserFromDTO(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setMobileNumber(userDTO.getMobile_number());
        user.setAddress(userDTO.getAddress());
        user.setCityId(userDTO.getCity_id());
        user.setStateId(userDTO.getState_id());
        user.setCountryId(userDTO.getCountry_id());
        user.setUserTypeId(userDTO. getUser_type_id());
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }
    public void deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + id);
        }

        userRepository.delete(optionalUser.get());
    }
    public User updateUser(Long id, User updatedUserDetails) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + id));

        existingUser.setName(updatedUserDetails.getName());
        existingUser.setEmail(updatedUserDetails.getEmail());
        existingUser.setPassword(passwordEncoder.encode(updatedUserDetails.getPassword()));
        existingUser.setMobileNumber(updatedUserDetails.getMobileNumber());
        existingUser.setAddress(updatedUserDetails.getAddress());
        existingUser.setCityId(updatedUserDetails.getCityId());
        existingUser.setStateId(updatedUserDetails.getStateId());
        existingUser.setCountryId(updatedUserDetails.getCountryId());
        existingUser.setUserTypeId(updatedUserDetails.getUserTypeId());

        return userRepository.save(existingUser);
    }
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

//public boolean validateCredentials(String email, String password) {
//        Optional<User> optionalUser = userRepository.findByEmail(email);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            return passwordEncoder.matches(password, user.getPassword());
//        }
//        return false;
//    }

//    public boolean validateCredentials(String email, String password) {
//        Optional<User> optionalUser = userRepository.findByEmail(email);
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            return passwordEncoder.matches(password, user.getPassword());
//        }
//        return false;
//    }

    public boolean validateCredentials(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }







    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
