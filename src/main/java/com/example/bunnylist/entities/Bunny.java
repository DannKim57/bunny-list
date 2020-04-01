package com.example.bunnylist.entities;

import java.util.List;

public class Bunny {
    private int id;
    private String name;
    private String description;
    private List<Carrot> carrots;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public List<Carrot> getCarrots() {
        return carrots;
    }

    public void setCarrots(List<Carrot> carrots) {
        this.carrots = carrots;
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Bunny other = (Bunny) obj;
        if (id != other.id)
            return false;
        return true;
    }


    
    
}