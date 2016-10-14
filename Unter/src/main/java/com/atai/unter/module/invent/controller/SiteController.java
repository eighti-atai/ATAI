package com.atai.unter.module.invent.controller;

import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.hibernate.validator.HibernateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.module.invent.model.Site;
import com.atai.unter.module.invent.service.SiteService;

@RestController
public class SiteController {

	private SiteService siteService;
	Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@Autowired
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	
	@RequestMapping(value = "/sites", method=RequestMethod.GET)
	public ModelAndView listSites(Model model)
	{
		model.addAttribute("site", new Site());
		model.addAttribute("listSites", this.siteService.listSites());
		/*return "sites";*/
		return new ModelAndView("sites").addObject("listSites", this.siteService.listSites());
	}
	
	@RequestMapping(value = "/site/add")
	public String addPerson(@ModelAttribute("site") Site site, 
			@RequestParam("searchfield") String searchField, BindingResult bindingResult, Model model){
	//public String addPerson(@Valid Site site, BindingResult bindingResult, Model model){	
	
		if (searchField.equals("TRUE"))
		{
			site = siteService.getSiteById(site.getSiteId());
			model.addAttribute("site", site);
			return "sites";
		}
		else
		{
			//validator.validate(site, bindingResult);
			System.out.println("--------------- in the addPerson Controller");
			if (bindingResult.hasErrors())
			{
				System.out.println("Binding errors -----------------------");
				return "sites";
			}
			//model.addAttribute("site", site);
			if (site.getObjid().equals(""))
			{
				this.siteService.addSite(site);
			}
			else
			{
				this.siteService.updateSite(site);
			}
			return "redirect:/sites";
		}
		
	}
}
