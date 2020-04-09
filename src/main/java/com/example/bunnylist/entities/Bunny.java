package com.example.bunnylist.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;


@Entity
@Table(name= "bunnies")
public class Bunny implements Serializable{
    
    private Long id;
    private String title;
    private String where;
    private LocalDate startDate;
    private Set<Carrot> carrots;


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

    protected Set<Carrot> getCarrotsInternal() {
		if (this.carrots == null) {
			this.carrots = new HashSet<>();
		}
		return this.carrots;
	}

	protected void setCarrotsInternal(Set<Carrot> carrots) {
		this.carrots = carrots;
	}
    

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bunny")
    public List<Carrot> getCarrots() {
        List<Carrot> sortedCarrots = new ArrayList<>(getCarrotsInternal());
        PropertyComparator.sort(sortedCarrots, new MutableSortDefinition("name", true, true));
        return Collections.unmodifiableList(sortedCarrots);
    }

    public void addCarrot(Carrot carrot) {
        if (carrot.isNew()) {
            getCarrotsInternal().add(carrot);
        }
        carrot.setBunny(this);
	}
    


    public Carrot getCarrot(String name) {
        return getCarrot(name, false);
    }

    public Carrot getCarrot(String name, boolean ignoreNew) {
        name = name.toLowerCase();
        for (Carrot carrot : getCarrotsInternal()) {
            if (!ignoreNew || !carrot.isNew()) {
                String compName = carrot.getName();
                compName = compName.toLowerCase();
                if (compName.equals(name)) {
                    return carrot;
                }
            }
        }
        return null;
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

    public boolean isNew() {
		return this.id == null;
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