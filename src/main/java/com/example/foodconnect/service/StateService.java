package com.example.foodconnect.service;

import com.example.foodconnect.entity.State;
import com.example.foodconnect.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public State getStateById(Long id) {
        return stateRepository.findById(id).orElse(null);
    }

    public State createState(State state) {
        return stateRepository.save(state);
    }

    public State updateState(Long id, State updatedState) {
        State existingState = stateRepository.findById(id).orElse(null);
        if (existingState != null) {
            existingState.setName(updatedState.getName());
            existingState.setCountryId(updatedState.getCountryId());
            return stateRepository.save(existingState);
        }
        return null;
    }

    public void deleteState(Long id) {
        stateRepository.deleteById(id);
    }
}
