package com.atai.unter.module.invent.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.atai.unter.module.invent.model.InventoryPart;
import com.atai.unter.module.invent.model.InventoryPartKey;
import com.atai.unter.module.invent.model.UoM;
import com.atai.unter.module.invent.service.InventoryPartService;
import com.atai.unter.module.invent.service.UoMService;;

@Component
public class InventoryPartValidator implements Validator {

	@Autowired
	private InventoryPartService invPartService;
	@Autowired
	private UoMService uoMService;
	
	public boolean supports(Class clazz) {
		return InventoryPart.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
        InventoryPart form = (InventoryPart)target;
        String uoMId = form.getUomId();
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "invPartNo", "error.invPartNo", "First name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "error.description", "Last name is required.");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uom", "error.uom", "Email is required.");
		
        if (form.isNew()) {
        	if(validateNewInventoryPart(errors, form, form.getId()))
        	{
        		if(uoMId != null){
        			validateUoM(errors, uoMId);
        		}
        	}
        }
	}
	
    private boolean validateNewInventoryPart(Errors errors, InventoryPart form, InventoryPartKey invPartId) {
    	
        InventoryPart invPart = invPartService.getInventoryPartById(invPartId);
        if (invPart != null) {
        	errors.reject("invPart.exists", "Inventory Part already exists");
        	return false;
        }
        return true;
    }
	
    private boolean validateUoM(Errors errors, String uoMId) {
    	
        UoM uoM = uoMService.getByKey(uoMId);
        if (uoM == null) {
        	errors.reject("uom.notExists", "UoM is not exists.");
        	return false;
        }
        return true;
    }
}
