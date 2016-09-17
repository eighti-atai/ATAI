package com.atai.unter.module.invent.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.module.invent.service.InventoryPartService;
import com.atai.unter.module.invent.validator.InventoryPartValidator;
import com.atai.unter.module.invent.model.InventoryPart;

@Controller
public class InventoryPartController {
	
	private InventoryPartService invPartService;
	
	@Autowired
	InventoryPartValidator inventoryPartValidator;
 
	@Autowired(required=true)
	@Qualifier(value="invPartService")
	public void setInvPartService(InventoryPartService invPartService) {
		this.invPartService = invPartService;
	}
	
	@RequestMapping(value="/inventoryPart", method=RequestMethod.GET)
	public String listInvebtoryParts(Model model)
	{
		model.addAttribute("invPart", new InventoryPart());
		model.addAttribute("listInvParts", this.invPartService.listInventoryParts());
		return "inventoryPart";
	}
	
	
	@RequestMapping(value="/showAddInventoryPart", method=RequestMethod.GET)
	public ModelAndView showForm()
	{
		return new ModelAndView("handleInventoryPart", "addInventoryPart", new InventoryPart());
	}
	/*
	@RequestMapping(value="/inventoryPart/add", method=RequestMethod.POST)
	public String addInventoryPart(@ModelAttribute("addInventoryPart") InventoryPart inventoryPart)
	{
		invPartService.addInventoryPart(inventoryPart);
		return "redirect:/inventoryPart";
	}
	

	@RequestMapping(value="/inventoryPart/add", method = RequestMethod.GET)
    public String setupForm(Model model) 
	{
		InventoryPart inventoryPart = new InventoryPart();
		 model.addAttribute("addInventoryPart", inventoryPart);
		 return "handleInventoryPart";
    }*/
	
	@RequestMapping(value="/inventoryPart/add", method=RequestMethod.POST)
	public String addInventoryPart(@ModelAttribute("addInventoryPart") InventoryPart inventoryPart,
									BindingResult result, Model model)
	{
		inventoryPart.setUom("1");
		inventoryPartValidator.validate(inventoryPart, result);
		
		if(result.hasErrors())
		{
			return "handleInventoryPart";
		}
		else
		{
			invPartService.addInventoryPart(inventoryPart);
			return "redirect:/inventoryPart";
		}
	}
	
}
