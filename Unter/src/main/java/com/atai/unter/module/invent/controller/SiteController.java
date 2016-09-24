package com.atai.unter.module.invent.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.atai.unter.module.invent.model.Site;
import com.atai.unter.module.invent.service.SiteService;

@Controller
public class SiteController {

	private SiteService siteService;

	@Autowired
	public void setSiteService(SiteService siteService) {
		this.siteService = siteService;
	}
	
	@RequestMapping(value = "/sites", method=RequestMethod.GET)
	public String listSites(Model model)
	{
		model.addAttribute("site", new Site());
		model.addAttribute("listSites", this.siteService.listSites());
		return "sites";
	}
	
	@RequestMapping(value = "/site/add")
	public String addPerson(@Valid @ModelAttribute("site") Site site, BindingResult bindingResult, Model model){
	//public String addPerson(@Valid Site site, BindingResult bindingResult, Model model){	
	
		System.out.println("--------------- in the addPerson Controller");
		if (bindingResult.hasErrors())
		{
			System.out.println("Binding errors -----------------------");
			return "sites";
		}
		//model.addAttribute("site", site);
		this.siteService.addSite(site);
		return "redirect:/sites";
	}
}
