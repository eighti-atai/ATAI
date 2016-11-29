package com.atai.unter.module.invent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.module.invent.model.InventoryLocation;
import com.atai.unter.module.invent.model.InventoryLocationKey;
import com.atai.unter.module.enterprise.model.Site;
import com.atai.unter.module.invent.service.InventoryLocationService;
import com.atai.unter.module.enterprise.service.SiteService;
import com.atai.unter.module.enterprise.service.SiteServiceImpl;

@RestController
public class InventoryLocationController {
	private InventoryLocationService invLocationService;

	@Autowired
	public void setInvLocationService(InventoryLocationService invLocationService) {
		this.invLocationService = invLocationService;
	}
	
	@GetMapping(value = "/invlocations")
	public ModelAndView listLocation(Model model)
	{
		return new ModelAndView("inventorylocations");//.addObject("listSites", this.siteService.listSites());
	}
	

	@GetMapping(value = "/InventoryLocation")
	public ResponseEntity<List<InventoryLocation>> listLocations()
	{
		List<InventoryLocation> locations = this.invLocationService.listData();
		return new ResponseEntity<List<InventoryLocation>>(locations, HttpStatus.OK);
	}
	
	@PostMapping(value = "/InventoryLocation")
	public ResponseEntity<Void> addLocation(@RequestBody InventoryLocation location){
	
		System.out.println("Inventory Location object will be added");
		this.invLocationService.addData(location);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/InventoryLocation")
	ResponseEntity<InventoryLocation> modifyLocation(@RequestBody InventoryLocation newLocation)
	{
		InventoryLocation oldLocation = invLocationService.getInventoryLocationByObjid(newLocation.getObjid());
		newLocation.setId(oldLocation.getId());
		invLocationService.updateData(newLocation);
		return new ResponseEntity<InventoryLocation>(newLocation, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/InventoryLocation/{objid:.+}")
	public ResponseEntity<InventoryLocation> deleteLocation(@PathVariable("objid") String objid) {
        System.out.println("Fetching & Deleting Location with id " + objid);
  
        InventoryLocation invLocation = invLocationService.getInventoryLocationByObjid(objid);
        if (invLocation == null) {
            System.out.println("Unable to delete. Sales Part with id " + objid + " not found");
            return new ResponseEntity<InventoryLocation>(HttpStatus.NOT_FOUND);
        }
  
        invLocationService.removeInventoryLocation(invLocation.getId());
        return new ResponseEntity<InventoryLocation>(HttpStatus.NO_CONTENT);
    }
	
	@PostMapping(value = "/InventoryLocation/Search")
	ResponseEntity<List<InventoryLocation>> searchSite(@RequestBody InventoryLocation invLocation)
	{
		List<InventoryLocation> invLocations = this.invLocationService.executeSelectQuery(invLocation);
		return new ResponseEntity<List<InventoryLocation>>(invLocations, HttpStatus.OK);
	}
}
