package com.example.foodconnect.controller;

import com.example.foodconnect.entity.State;
import com.example.foodconnect.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @GetMapping("/{id}")
    public State getStateById(@PathVariable Long id) {
        return stateService.getStateById(id);
    }

    @PostMapping
    public State createState(@RequestBody State state) {
        return stateService.createState(state);
    }

    @PutMapping("/{id}")
    public State updateState(@PathVariable Long id, @RequestBody State state) {
        return stateService.updateState(id, state);
    }

    @DeleteMapping("/{id}")
    public void deleteState(@PathVariable Long id) {
        stateService.deleteState(id);
    }
}
