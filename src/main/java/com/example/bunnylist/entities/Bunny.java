package com.example.bunnylist.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name= "bunnies")
public class Bunny implements Serializable{
    
    private Long id;
    private String title;
    private String where;
    private LocalDate startDate;
    private List<Carrot> carrots;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "_title")
    @NotEmpty
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bunny")
    public List<Carrot> getCarrots() {
        return carrots;
    }

    public void setCarrots(List<Carrot> carrots) {
        this.carrots = carrots;
    }

    @Column(name = "_where")
    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    @Column(name = "start_Date")
    @NotEmpty
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
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


    @Override
    public String toString() {
        return "Bunny [where=" + where + ", id=" + id + ", title=" + title + "]";
    }
    
    
}