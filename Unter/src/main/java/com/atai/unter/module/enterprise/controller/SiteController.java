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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.module.enterprise.model.Site;
import com.atai.unter.module.enterprise.service.SiteService;

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
		/*return "sites";*/
		return new ModelAndView("site2");//.addObject("listSites", this.siteService.listSites());
	}
	
	@CrossOrigin(origins = "http://kanslk1:8080", maxAge = 3600)
	@RequestMapping(value = "/Site", method = RequestMethod.GET)
	public ResponseEntity<List<Site>> listSites2()
	{
		List<Site> sites = this.siteService.listSites();
		System.out.println("test-------------------");
		return new ResponseEntity<List<Site>>(sites, HttpStatus.OK);
		//model.addAttribute("site", new Site());
		//model.addAttribute("listSites", this.siteService.listSites());
		/*return "sites";*/
		//return new ModelAndView("sites").addObject("listSites", this.siteService.listSites());
	}
	
	@RequestMapping(value = "/site2/add", method= RequestMethod.POST)
	public ResponseEntity<Void> addPerson(@RequestBody Site site){
	//public String addPerson(@Valid Site site, BindingResult bindingResult, Model model){	
	
		/*if (searchField.equals("TRUE"))
		{
			site = siteService.getSiteById(site.getSiteId());
			model.addAttribute("site", site);
			return "sites";
		}
		else
		{*/
			//validator.validate(site, bindingResult);
			/*System.out.println("--------------- in the addPerson Controller");
			if (bindingResult.hasErrors())
			{
				System.out.println("Binding errors -----------------------");
				return "sites";
			}*/
			//model.addAttribute("site", site);
			if (site.getObjid().equals(""))
			{
				System.out.println("Site object will be added");
				this.siteService.addSite(site);
			}
			else
			{
				System.out.println("Site object will be updated");
				this.siteService.updateSite(site);
			}
			
		//}
			return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
