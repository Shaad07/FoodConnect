package com.example.foodconnect.repository;

import com.example.foodconnect.entity.Slum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlumRepository extends JpaRepository<Slum, Long> {
}
