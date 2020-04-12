package com.example.bunnylist.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
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

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "carrots")
public class Carrot implements Serializable {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "start_Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;

	@ManyToOne
	@JoinColumn(name = "type_Id")
	private CarrotType type;

	@ManyToOne
	@JoinColumn(name = "bunny_Id", nullable = false)
	private Bunny bunny;

	@Transient
	private Set<Visit> visits = new LinkedHashSet<>();

	public Long getId() {
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

	public Bunny getBunny() {
		return bunny;
	}

	public void setBunny(Bunny bunny) {
		this.bunny = bunny;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public CarrotType getType() {
		return type;
	}

	public void setType(CarrotType type) {
		this.type = type;
	}

	protected Set<Visit> getVisitsInternal() {
		if (this.visits == null) {
			this.visits = new HashSet<>();
		}
		return this.visits;
	}

	public void setVisitsInternal(Collection<Visit> visits) {
		this.visits = new LinkedHashSet<>(visits);
	}

	public List<Visit> getVisits() {
		List<Visit> sortedVisits = new ArrayList<>(getVisitsInternal());
		PropertyComparator.sort(sortedVisits, new MutableSortDefinition("date", false, false));
		return Collections.unmodifiableList(sortedVisits);
	}

	public void addVisit(Visit visit) {
		getVisitsInternal().add(visit);
		visit.setCarrotId(this.getId());
	}

	public boolean isNew() {
		return this.id == null;
	}

}