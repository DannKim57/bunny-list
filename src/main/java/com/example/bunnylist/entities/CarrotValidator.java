package com.example.bunnylist.entities;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CarrotValidator implements Validator {

	private static final String REQUIRED = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		Carrot carrot = (Carrot) obj;
		String name = carrot.getName();
		// name validation
		if (!StringUtils.hasLength(name)) {
			errors.rejectValue("name", REQUIRED, REQUIRED);
		}

		// type validation
		if (carrot.isNew() && carrot.getType() == null) {
			errors.rejectValue("type", REQUIRED, REQUIRED);
		}

		// birth date validation
		if (carrot.getStartDate() == null) {
			errors.rejectValue("startDate", REQUIRED, REQUIRED);
		}
	}

	/**
	 * This Validator validates *just* Carrot instances
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Carrot.class.isAssignableFrom(clazz);
	}

}