package com.example.foodconnect.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "slum")
public class Slum {

    @Id
    private Long slumId;

    private String name;

    private Long cityId;

    private Long population;

    // Getters and setters
    public Long getSlumId() {
        return slumId;
    }

    public void setSlumId(Long slumId) {
        this.slumId = slumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }
}
