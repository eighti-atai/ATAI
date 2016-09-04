package com.atai.unter.module.invent.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atai.unter.module.invent.service.InventoryPartService;
import com.atai.unter.module.invent.model.InventoryPart;

@Controller
public class InventoryPartController {
	
	private InventoryPartService invPartService;

	@Autowired(required=true)
	@Qualifier(value="invPartService")
	public void setInvPartService(InventoryPartService invPartService) {
		this.invPartService = invPartService;
	}
	
	@RequestMapping(value="/inventoryPart", method=RequestMethod.GET)
	public String listPersons(Model model)
	{
		model.addAttribute("invPart", new InventoryPart());
		model.addAttribute("listInvParts", this.invPartService.listInventoryParts());
		return "inventoryPart";
	}
}
