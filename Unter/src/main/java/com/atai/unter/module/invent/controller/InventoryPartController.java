package com.atai.unter.module.invent.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//@RequestMapping(value="/invParts", method=RequestMethod.GET)
	@GetMapping(value="/invPart")
	public ModelAndView showForm(Model Model)
	{
		return new ModelAndView("inventoryPart");
	}
	
	@GetMapping(value="/invParts")
	public ResponseEntity<List<InventoryPart>> getRecords()
	{
		List<InventoryPart> invParts = this.invPartService.listData();
		return new ResponseEntity<List<InventoryPart>>(invParts, HttpStatus.OK);
	}
	
	//@RequestMapping(value="/inventoryPart/add", method=RequestMethod.POST)
	//public String addInventoryPart(@ModelAttribute("addInventoryPart") InventoryPart inventoryPart,
	//								BindingResult result, Model model)
	@PostMapping(value="/invPart")
	public ResponseEntity<Void> addInventoryPart(@RequestBody InventoryPart invPart)
	{
		System.out.println("Inventory Part is Successfully added.");
		this.invPartService.addData(invPart);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
}
