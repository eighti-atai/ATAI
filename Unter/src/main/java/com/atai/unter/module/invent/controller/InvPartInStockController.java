package com.atai.unter.module.invent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.module.invent.model.InvPartInStock;
import com.atai.unter.module.invent.service.InvPartInStockService;

@RestController
public class InvPartInStockController {
	
	InvPartInStockService invPartInStockService;

	@Autowired
	public void setInvPartInStockService(InvPartInStockService invPartInStockService) {
		this.invPartInStockService = invPartInStockService;
	}
	
	
	@GetMapping(value = "/invpartinstocks")
	public ModelAndView listInvPartInStocks(Model model)
	{
		return new ModelAndView("invpartinstock");
	}
	
	
	@GetMapping(value = "/InvPartInStock")
	public ResponseEntity<List<InvPartInStock>> listInvPartInStocks()
	{
		List<InvPartInStock> invPartInStocks = this.invPartInStockService.listData();
		return new ResponseEntity<List<InvPartInStock>>(invPartInStocks, HttpStatus.OK);
	}
	
	
	@PostMapping(value = "/InvPartInStock")
	public ResponseEntity<Void> addInvPartInStock(@RequestBody InvPartInStock invPartInStock){
	
		System.out.println("Inventory Part In Stock object will be added");
		this.invPartInStockService.addData(invPartInStock);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	@PutMapping(value = "/InvPartInStock")
	ResponseEntity<InvPartInStock> modifyInvPartInStock(@RequestBody InvPartInStock newInvPartInStock)
	{
		InvPartInStock oldInvPartInStock = invPartInStockService.getByObjid(newInvPartInStock.getObjid());
		newInvPartInStock.setId(oldInvPartInStock.getId());
		invPartInStockService.updateData(newInvPartInStock);
		return new ResponseEntity<InvPartInStock>(newInvPartInStock, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value = "/InvPartInStock/{objid:.+}")
	public ResponseEntity<InvPartInStock> deleteInvPartInStock(@PathVariable("objid") String objid) {
        System.out.println("Fetching & Deleting Inv Part In Stock with id " + objid);
  
        InvPartInStock invPartInStock = invPartInStockService.getByObjid(objid);
        if (invPartInStock == null) {
            System.out.println("Unable to delete. Inventory Part In Stock with id " + objid + " not found");
            return new ResponseEntity<InvPartInStock>(HttpStatus.NOT_FOUND);
        }
  
        invPartInStockService.removeInvPartInStock(invPartInStock.getId());
        return new ResponseEntity<InvPartInStock>(HttpStatus.NO_CONTENT);
    }
	
	@PostMapping(value = "/InvPartInStock/Search")
	ResponseEntity<List<InvPartInStock>> searchInvPartInStock(@RequestBody InvPartInStock invPartCost)
	{
		List<InvPartInStock> invPartInStocks = this.invPartInStockService.executeSelectQuery(invPartCost);
		return new ResponseEntity<List<InvPartInStock>>(invPartInStocks, HttpStatus.OK);
	}
}
