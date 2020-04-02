package com.example.bunnylist.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Bunny {
    
    private long id;
    private String name;
    private String description;
    private List<Carrot> carrots;

    public Bunny() {}
    public Bunny(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public long getId() {
        return id;
    }

    public void setId(Long id) {
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
    

    

    @Override
    public String toString() {
        return "Bunny [description=" + description + ", id=" + id + ", name=" + name + "]";
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bunny")
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
        result = prime * result + (int) (id ^ (id >>> 32));
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