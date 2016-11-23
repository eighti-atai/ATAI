package com.atai.unter.module.enterprise.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.atai.unter.module.enterprise.model.Site;
import com.atai.unter.module.enterprise.service.SiteService;
import com.atai.unter.module.order.model.SalesPart;


@RestController
public class SiteController {

	private SiteService siteService;
	//Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Autowired
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	
	@RequestMapping(value = "/site2", method=RequestMethod.GET)
	public ModelAndView listSites(Model model)
	{
		model.addAttribute("site", new Site());
		model.addAttribute("listSites", this.siteService.listSites());
		return new ModelAndView("site2");//.addObject("listSites", this.siteService.listSites());
	}
	
	@CrossOrigin(origins = "http://kanslk1:8080", maxAge = 3600)
	@RequestMapping(value = "/Site", method = RequestMethod.GET)
	public ResponseEntity<List<Site>> listSites2()
	{
		List<Site> sites = this.siteService.listSites();
		return new ResponseEntity<List<Site>>(sites, HttpStatus.OK);
	}
	
	@PostMapping(value = "/Site")
	public ResponseEntity<Void> addSite(@RequestBody Site site){
	
		System.out.println("Site object will be added");
		this.siteService.addSite(site);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/Site")
	ResponseEntity<Site> modifySite(@RequestBody Site newSite)
	{
		Site oldSite = siteService.getSiteByObjid(newSite.getObjid());
		newSite.setSiteId(oldSite.getSiteId());
		this.siteService.updateSite(newSite);
		return new ResponseEntity<Site>(newSite, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Site/{objid:.+}", method = RequestMethod.DELETE)
	public ResponseEntity<Site> deleteSite(@PathVariable("objid") String objid) {
        System.out.println("Fetching & Deleting Site with id " + objid);
  
        Site site = siteService.getSiteByObjid(objid);
        if (site == null) {
            System.out.println("Unable to delete. Sales Part with id " + objid + " not found");
            return new ResponseEntity<Site>(HttpStatus.NOT_FOUND);
        }
  
        siteService.removeSite(site.getSiteId());
        return new ResponseEntity<Site>(HttpStatus.NO_CONTENT);
    }
	
	@PostMapping(value = "/Site/Search")
	ResponseEntity<List<Site>> searchSite(@RequestBody Site site)
	{
		List<Site> sites = this.siteService.executeSelectQuery(site);
		return new ResponseEntity<List<Site>>(sites, HttpStatus.OK);
	}
}
