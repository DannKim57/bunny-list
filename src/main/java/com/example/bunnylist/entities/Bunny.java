package com.example.bunnylist.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Bunny {

    private Logger logger = LoggerFactory.getLogger(Bunny.class);
    @Id
    private String id;
    private String name;
    private String description;
    private List<Carrot> carrots;

    public Bunny() {}
    public Bunny(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    public void sayHi() {
        logger.info("Hello! from " + id);
    }


    
    
}