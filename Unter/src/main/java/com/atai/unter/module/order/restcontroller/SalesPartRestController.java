package com.atai.unter.module.order.restcontroller;


/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		model.addAttribute("addSalesPart", new SalesPart());
		model.addAttribute("listSalesP", this.salesPartService.listSalesPart());
		return "salespart";
	}

	@RequestMapping(value="/salespart/add", method={ RequestMethod.GET, RequestMethod.POST })
	public String addSalesPart(@ModelAttribute("addSalesPart") SalesPart salesPart)
	{
		salesPartService.addSalesPart(salesPart);
		return "redirect:/salespart";
	}
	
	
}*/


import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import com.atai.unter.module.order.model.SalesPart;
import com.atai.unter.module.order.service.SalesPartService;
 
  
@RestController
public class SalesPartRestController {
  
    @Autowired
    SalesPartService salesPartService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Records--------------------------------------------------------
    
    
    
    @RequestMapping(value= "/salespartlist1",method = RequestMethod.GET)
    public ModelAndView getIndexPage() {
    	ModelAndView a = new ModelAndView("salespartlist");
	  System.out.println("############################################# 01_1");
        return a;
    }
      
    @RequestMapping(value = "/SalesPart/", method = RequestMethod.GET)
    public ResponseEntity<List<SalesPart>> listAllSalesParts() {
    	System.out.println("############################################# 01");
        List<SalesPart> salesParts = salesPartService.listSalesPart();
        if(salesParts.isEmpty()){
            return new ResponseEntity<List<SalesPart>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<SalesPart>>(salesParts, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single Record--------------------------------------------------------
      
    @RequestMapping(value = "/SalesPart/{salesPartId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalesPart> getSalesPart(@PathVariable("salesPartId") String salesPartId) {
        System.out.println("Fetching Sales Part with id " + salesPartId);
        SalesPart salesPart = salesPartService.getSalesPartById(salesPartId);
        if (salesPart == null) {
            System.out.println("Sales Part with id " + salesPartId + " not found");
            return new ResponseEntity<SalesPart>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SalesPart>(salesPart, HttpStatus.OK);
    }
  
      
      
    //-------------------Create--------------------------------------------------------
      
    @RequestMapping(value = "/SalesPart/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSalesPart(@RequestBody SalesPart salesPart,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating salesPart " + salesPart.getdescription());
  
        //if (salesPartService.isUserExist(salesPart)) {
           // System.out.println("A Sales Part with name " + salesPart.getUsername() + " already exist");
           // return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        //}
  
        salesPartService.addSalesPart(salesPart);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/SalesPart/{salesPartId}").buildAndExpand(salesPart.getsalesPartId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update --------------------------------------------------------
      
    /*@RequestMapping(value = "/SalesPart/{objid:.+}", method = RequestMethod.PUT)
    public ResponseEntity<SalesPart> updateSalesPart(@PathVariable("objid") String objid, @RequestBody SalesPart salesPart) {
        SalesPart currentSalesPart = salesPartService.getSalesPartByObjid(objid);
          
        if (currentSalesPart==null) {
            System.out.println("objid with id " + objid + " not found");
            return new ResponseEntity<SalesPart>(HttpStatus.NOT_FOUND);
        }
  
        currentSalesPart.setdescription(salesPart.getdescription());
        currentSalesPart.setInvPartNo(salesPart.getInvPartNo());
        currentSalesPart.setInvConversionFactor(salesPart.getInvConversionFactor());
        currentSalesPart.setUom(salesPart.getUom());
        currentSalesPart.setPriceCategory(salesPart.getPriceCategory());
        currentSalesPart.setGeneralCategory(salesPart.getGeneralCategory());
         
        salesPartService.updateSalesPart(currentSalesPart);
        return new ResponseEntity<SalesPart>(currentSalesPart, HttpStatus.OK);
    }*/
  
     @PutMapping(value = "/SalesPart")
     public ResponseEntity<SalesPart> updateSalesPart(@RequestBody SalesPart newSalesPart) {
         SalesPart oldSalesPart = salesPartService.getSalesPartByObjid(newSalesPart.getObjid());
           
         if (oldSalesPart==null) {
             System.out.println("objid with id " + newSalesPart.getObjid() + " not found");
             return new ResponseEntity<SalesPart>(HttpStatus.NOT_FOUND);
         }
   
         newSalesPart.setsalesPartId(oldSalesPart.getsalesPartId());
          
         salesPartService.updateSalesPart(newSalesPart);
         return new ResponseEntity<SalesPart>(newSalesPart, HttpStatus.OK);
     }
    
    //------------------- Delete --------------------------------------------------------
      
    @RequestMapping(value = "/SalesPart/{objid:.+}", method = RequestMethod.DELETE)
    public ResponseEntity<SalesPart> deleteSalesPart(@PathVariable("objid") String objid) {
        System.out.println("Fetching & Deleting User with id " + objid);
  
        SalesPart salesPart = salesPartService.getSalesPartByObjid(objid);
        if (salesPart == null) {
            System.out.println("Unable to delete. Sales Part with id " + objid + " not found");
            return new ResponseEntity<SalesPart>(HttpStatus.NOT_FOUND);
        }
  
        salesPartService.removeSalesPart(salesPart.getsalesPartId());
        return new ResponseEntity<SalesPart>(HttpStatus.NO_CONTENT);
    }
  
      
     
    //------------------- Delete All Records --------------------------------------------------------
      
    /*@RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<SalesPart> deleteAllUsers() {
        System.out.println("Deleting All Users");
  
        salesPartService.deleteAllUsers();
        return new ResponseEntity<SalesPart>(HttpStatus.NO_CONTENT);
    }*/
  
}
