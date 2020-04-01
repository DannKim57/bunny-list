package com.example.bunnylist.entities;

import java.util.Date;
import java.util.List;

public class Carrot {
    private String id;
    private Date carrotPlanted;
    private boolean onGoing; // on or off
    private String features;
    private List<String> rows;
    private String bunnyId; // @Many to one .. I still don't create a getter and a setter for this one. 

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

    public List<String> getRows() {
        return rows;
    }

    public void setRows(List<String> rows) {
        this.rows = rows;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}