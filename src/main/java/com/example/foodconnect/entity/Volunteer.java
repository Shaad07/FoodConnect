package com.example.foodconnect.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "volunteer")
public class Volunteer {

    @Id
    private Long volunteerId;

    private Long userId;

    private String availabilityStatus;

    private Long assignedTaskId;

    // Getters and setters
    public Long getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(Long volunteerId) {
        this.volunteerId = volunteerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public Long getAssignedTaskId() {
        return assignedTaskId;
    }

    public void setAssignedTaskId(Long assignedTaskId) {
        this.assignedTaskId = assignedTaskId;
    }
}
