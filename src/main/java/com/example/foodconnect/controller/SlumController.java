package com.example.foodconnect.controller;

import com.example.foodconnect.entity.Slum;
import com.example.foodconnect.service.SlumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/slums")
public class SlumController {

    @Autowired
    private SlumService slumService;

    @GetMapping
    public List<Slum> getAllSlums() {
        return slumService.getAllSlums();
    }

    @GetMapping("/{id}")
    public Slum getSlumById(@PathVariable Long id) {
        return slumService.getSlumById(id);
    }

    @PostMapping
    public Slum createSlum(@RequestBody Slum slum) {
        return slumService.createSlum(slum);
    }

    @PutMapping("/{id}")
    public Slum updateSlum(@PathVariable Long id, @RequestBody Slum slum) {
        return slumService.updateSlum(id, slum);
    }

    @DeleteMapping("/{id}")
    public void deleteSlum(@PathVariable Long id) {
        slumService.deleteSlum(id);
    }
}
