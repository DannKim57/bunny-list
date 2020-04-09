package com.example.bunnylist.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "visits")
public class Visit {
    private long id;
    private LocalDate date;
    private String description;
    private long carrotId;

    public Visit() {
        this.date = LocalDate.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    @Column(name = "startDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getStartDate() {
        return date;
    }

    public void setStartDate(LocalDate date) {
        this.date = date;
    }

    @NotEmpty
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "carrotId")
    public long getCarrotId() {
        return carrotId;
    }

    public void setCarrotId(long carrotId) {
        this.carrotId = carrotId;
    }

    
    
}