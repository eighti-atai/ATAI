package com.atai.unter.module.invent.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.module.invent.service.InventoryPartService;
import com.atai.unter.module.invent.validator.InventoryPartValidator;
import com.atai.unter.module.invent.model.InventoryPart;

@RestController
public class InventoryPartController {
	
	@Autowired
	private InventoryPartService invPartService;
	   
	@Autowired
	InventoryPartValidator inventoryPartValidator;
 /*
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
	
	@RequestMapping(value="/inventoryPart/update/{no}", method=RequestMethod.GET)
	public String addInventoryPart(@PathVariable("no") String no, Model model)
	{
		InventoryPart invPart = this.invPartService.getInventoryPartByNo(no);
		model.addAttribute("addInventoryPart", invPart);
		model.addAttribute("msg", "update");
		return "handleInventoryPart";
	}
	
/*
	@RequestMapping(value="/inventoryPart/add", method = RequestMethod.GET)
    public String setupForm(Model model) 
	{
		InventoryPart inventoryPart = new InventoryPart();
		 model.addAttribute("addInventoryPart", inventoryPart);
		 return "handleInventoryPart";
    }*/
	
	
	@RequestMapping(value="/showAddInventoryPart", method=RequestMethod.GET)
	public ModelAndView showForm()
	{
		return new ModelAndView("inventoryPart");
	}
	
	
	@RequestMapping(value="/inventoryParts", method=RequestMethod.GET)
	public ResponseEntity<List<InventoryPart>> getRecords()
	{
		List<InventoryPart> invParts = this.invPartService.listInventoryParts();
		return new ResponseEntity<List<InventoryPart>>(invParts, HttpStatus.OK);
	}
	
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
