package com.atai.unter.module.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.atai.unter.module.order.model.SalesPart;
import com.atai.unter.module.order.service.SalesPartService;

@Controller
public class SalesPartController {
	private SalesPartService salesPartService;
	
	@Autowired(required = true)
	@Qualifier(value = "salesPartService")
	public void setSalesPartService(SalesPartService salesPartService) {
		this.salesPartService = salesPartService;
	}
	
	@RequestMapping(value="/salespart", method=RequestMethod.GET)
	public String listSalesPart(Model model)
	{
		model.addAttribute("salespart", new SalesPart());
		model.addAttribute("listSalesParts", this.salesPartService.listSalesPart());
		return "salespart";
	}

}
