package com.example.bunnylist.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Carrot {
    
    private long id;
    private Date carrotPlanted;
    private boolean onGoing; // on or off
    private String features;
    // private List<String> rows;
    private Bunny bunny; 

    public Date getCarrotPlanted() {
        return carrotPlanted;
    }

    public void setCarrotPlanted(Date carrotPlanted) {
        this.carrotPlanted = carrotPlanted;
    }

    public boolean isOnGoing() {
        return onGoing;
    }

    public void setOnGoing(boolean onGoing) {
        this.onGoing = onGoing;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    // public List<String> getRows() {
    //     return rows;
    // }

    // public void setRows(List<String> rows) {
    //     this.rows = rows;
    // }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @ManyToOne
    @JoinColumn(name = "Bunny_ID", nullable = false)
    public Bunny getBunny() {
        return bunny;
    }

    public void setBunny(Bunny bunny) {
        this.bunny = bunny;
    } 

    
}