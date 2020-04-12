package com.example.bunnylist.repositories;

import java.util.Collection;

import com.example.bunnylist.entities.Visit;

import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {

	Collection<Visit> findByCarrotId(Long carrotId);

}
