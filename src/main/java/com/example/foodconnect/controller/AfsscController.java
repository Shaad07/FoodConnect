package com.example.foodconnect.controller;

import com.example.foodconnect.entity.Afssc;
import com.example.foodconnect.service.AfsscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/afssc")
public class AfsscController {

    @Autowired
    private AfsscService afsscService;

    // Get all afssc records
    @GetMapping
    public List<Afssc> getAllAfssc() {
        return afsscService.getAllAfssc();
    }

    // Get afssc by ID
    @GetMapping("/{id}")
    public ResponseEntity<Afssc> getAfsscById(@PathVariable Long id) {
        return afsscService.getAfsscById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Create or update afssc record
    @PostMapping
    public Afssc saveAfssc(@RequestBody Afssc afssc) {
        return afsscService.saveAfssc(afssc);
    }

    // Delete afssc by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAfssc(@PathVariable Long id) {
        afsscService.deleteAfssc(id);
        return ResponseEntity.noContent().build();
    }
}
