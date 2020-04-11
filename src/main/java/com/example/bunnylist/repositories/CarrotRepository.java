package com.example.bunnylist.repositories;

import java.util.List;

import com.example.bunnylist.entities.Carrot;
import com.example.bunnylist.entities.CarrotType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface CarrotRepository extends CrudRepository<Carrot, Long>{
    
    @Query("SELECT ctype FROM CarrotType ctype ORDER BY ctype.name") // Or Type instead of CarrotType
    @Transactional
    List<CarrotType> findCarrotTypes();
}