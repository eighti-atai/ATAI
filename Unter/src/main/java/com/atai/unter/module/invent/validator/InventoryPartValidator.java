package com.atai.unter.module.invent.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.atai.unter.module.invent.model.InventoryPart;
import com.atai.unter.module.invent.model.InventoryPartKey;
import com.atai.unter.module.invent.service.InventoryPartService;;

@Component
public class InventoryPartValidator implements Validator {

	@Autowired
	private InventoryPartService invPartService;
	
	public boolean supports(Class clazz) {
		return InventoryPart.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "invPartNo", "error.invPartNo", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.description", "Last name is required.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uom", "error.uom", "Email is required.");
		
        InventoryPart form = (InventoryPart) target;
        if (form.isNew()) {
        	validateNewInventoryPart(errors, form, form.getId());         
        }
	}
    private void validateNewInventoryPart(Errors errors, InventoryPart form, InventoryPartKey invPartId) {
    	
        InventoryPart invPart = invPartService.getInventoryPartById(invPartId);
        if (invPart != null) {
            if (invPart.getId() != invPartId) {
                errors.reject("user.exists", "User with this username already exists");
            }
        }
    }
}
