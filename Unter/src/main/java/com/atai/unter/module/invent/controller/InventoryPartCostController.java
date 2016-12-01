package com.atai.unter.module.invent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.module.invent.model.InventoryPartCost;
import com.atai.unter.module.invent.service.InventoryPartCostService;

@Controller
public class InventoryPartCostController {

	InventoryPartCostService invPartCostService;

	@Autowired
	public void setInvPartCostService(InventoryPartCostService invPartCostService) {
		this.invPartCostService = invPartCostService;
	}
	
	
	@GetMapping(value = "/invPartCosts")
	public ModelAndView listInvPartCosts(Model model)
	{
		return new ModelAndView("invPartCosts");
	}
	
	
	@GetMapping(value = "/InventoryPartCost")
	public ResponseEntity<List<InventoryPartCost>> listInvPartCosts()
	{
		List<InventoryPartCost> invPartCosts = this.invPartCostService.listData();
		return new ResponseEntity<List<InventoryPartCost>>(invPartCosts, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/InventoryPartCost")
	public ResponseEntity<Void> addInventoryPartCost(@RequestBody InventoryPartCost invPartCost){
	
		System.out.println("Inventory Part Cost object will be added");
		this.invPartCostService.addData(invPartCost);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@PutMapping(value = "/InventoryPartCost")
	ResponseEntity<InventoryPartCost> modifyInventoryPartCost(@RequestBody InventoryPartCost newInvPartCost)
	{
		InventoryPartCost oldInvPartCost = invPartCostService.getByObjid(newInvPartCost.getObjid());
		newInvPartCost.setId(oldInvPartCost.getId());
		invPartCostService.updateData(newInvPartCost);
		return new ResponseEntity<InventoryPartCost>(newInvPartCost, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/InventoryPartCost/{objid:.+}")
	public ResponseEntity<InventoryPartCost> deleteInventoryPartCost(@PathVariable("objid") String objid) {
        System.out.println("Fetching & Deleting Cost with id " + objid);
  
        InventoryPartCost invPartCost = invPartCostService.getByObjid(objid);
        if (invPartCost == null) {
            System.out.println("Unable to delete. Inventory Part Cost with id " + objid + " not found");
            return new ResponseEntity<InventoryPartCost>(HttpStatus.NOT_FOUND);
        }
  
        invPartCostService.removeInventoryPartCost(invPartCost.getId());
        return new ResponseEntity<InventoryPartCost>(HttpStatus.NO_CONTENT);
    }
	
	
	@PostMapping(value = "/InventoryPartCost/Search")
	ResponseEntity<List<InventoryPartCost>> searchInventoryPartCost(@RequestBody InventoryPartCost invPartCost)
	{
		List<InventoryPartCost> invPartCosts = this.invPartCostService.executeSelectQuery(invPartCost);
		return new ResponseEntity<List<InventoryPartCost>>(invPartCosts, HttpStatus.OK);
	}
	
}
