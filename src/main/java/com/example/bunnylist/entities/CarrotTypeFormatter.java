package com.example.bunnylist.entities;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import com.example.bunnylist.repositories.CarrotRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CarrotTypeFormatter implements Formatter<CarrotType>{
    private final CarrotRepository carrotRepository;

    @Autowired
    public CarrotTypeFormatter(CarrotRepository carrotRepository) {
        this.carrotRepository = carrotRepository;
    }

    @Override
    public String print(CarrotType carrotType, Locale locale) {
        return carrotType.getName();
    }

    @Override
	public CarrotType parse(String text, Locale locale) throws ParseException {
		Collection<CarrotType> findCarrotTypes = this.carrotRepository.findCarrotTypes();
		for (CarrotType type : findCarrotTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}

    
    
}