package com.atai.unter.module.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.atai.unter.module.order.model.SalesPartPrice;
import com.atai.unter.module.order.service.SalesPartPriceService;

@Controller
public class SalesPartPriceController {

	private SalesPartPriceService salesPartPriceService;

	@Autowired
	public void setSalesPartPriceService(SalesPartPriceService salesPartPriceService) {
		this.salesPartPriceService = salesPartPriceService;
	}
	
	@GetMapping(value = "/salespartprices")
	public String listSalesPartPrice(Model model)
	{
		model.addAttribute("addSalesPartPrice", new SalesPartPrice());
		model.addAttribute("listSalesPartPrice", this.salesPartPriceService.listData());
		return "salespartprices";
	}
	

	@PostMapping(value = "/salespartprices/add")
	public String addSalesPartPrice(@ModelAttribute("salesPartPrice") SalesPartPrice salesPartPrice){
		this.salesPartPriceService.addData(salesPartPrice);
				
		return "redirect:/salespartprices";
	}
}
