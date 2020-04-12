package com.example.bunnylist.repositories;

import java.util.List;

import com.example.bunnylist.entities.Bunny;

import org.springframework.data.repository.CrudRepository;

public interface BunnyRepository extends CrudRepository<Bunny, Long> {

	public List<Bunny> findByTitle(String title);

}