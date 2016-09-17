package com.atai.unter.module.invent.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.atai.unter.module.invent.model.InventoryPart;

@Component
public class InventoryPartValidator implements Validator {

	public boolean supports(Class clazz) {
		return InventoryPart.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "invPartNo", "error.invPartNo", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.description", "Last name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uom", "error.uom", "Email is required.");
	}

}
