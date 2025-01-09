package com.example.foodconnect.repository;

import com.example.foodconnect.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); // Return Optional<User>
    Optional<User> findByEmailAndPassword(String email, String password);
}

