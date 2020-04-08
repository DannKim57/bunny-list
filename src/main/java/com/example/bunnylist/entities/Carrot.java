package com.example.bunnylist.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "carrots")
public class Carrot implements Serializable {
    
    private long id;
    private LocalDate startDate;
    private CarrotType type;
    private Bunny bunny; 
    private Set<Todo> todos = new LinkedHashSet<>();

    

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

    @Column(name = "startDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @ManyToOne
    @JoinColumn(name = "typeId")
    public CarrotType getType() {
        return type;
    }

    public void setType(CarrotType type) {
        this.type = type;
    }

    @Transient
    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    
}