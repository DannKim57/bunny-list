package com.example.bunnylist.repositories;

import com.example.bunnylist.entities.Todo;

import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}
