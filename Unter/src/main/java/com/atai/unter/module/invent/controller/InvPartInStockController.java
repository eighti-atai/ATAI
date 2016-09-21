package com.atai.unter.module.invent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.atai.unter.module.invent.model.InvPartInStock;
import com.atai.unter.module.invent.service.InvPartInStockService;

@Controller
public class InvPartInStockController {
	
	InvPartInStockService invPartInStockService;

	@Autowired
	public void setInvPartInStockService(InvPartInStockService invPartInStockService) {
		this.invPartInStockService = invPartInStockService;
	}
	
	@GetMapping(value = "/invpartinstock")
	public String listInvPartInStock(Model model)
	{
		model.addAttribute("invPartInStock", new InvPartInStock());
		model.addAttribute("listInvPartInStock", this.invPartInStockService.listData());
		return "invpartinstock";
	}
	

	@PostMapping(value = "/invpartinstock/add")
	public String addInvPartInStock(@ModelAttribute("invPartInStock") InvPartInStock invPartInStock, 
									@RequestParam("id.invPartNo") String invPartNo,
									@RequestParam("id.invPartCostNo") int invPartCostNo,
									@RequestParam("id.siteId") String siteId, 
									@RequestParam("id.invLocationId") String invLocationId){
		invPartInStock.setId(invPartNo, invPartCostNo, siteId, invLocationId );
		this.invPartInStockService.addData(invPartInStock);
				
		return "redirect:/invpartinstock";
	}

}
