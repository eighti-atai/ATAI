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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.atai.unter.module.order.model.SalesPart;
import com.atai.unter.module.order.service.SalesPartService;
 
  
@RestController
public class SalesPartRestController {
  
    @Autowired
    SalesPartService salesPartService;  //Service which will do all data retrieval/manipulation work
  
     
    //-------------------Retrieve All Users--------------------------------------------------------
      
    @RequestMapping(value = "/SalesPart/", method = RequestMethod.GET)
    public ResponseEntity<List<SalesPart>> listAllSalesParts() {
    	System.out.println("############################################# 01");
        List<SalesPart> salesParts = salesPartService.listSalesPart();
        if(salesParts.isEmpty()){
            return new ResponseEntity<List<SalesPart>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<SalesPart>>(salesParts, HttpStatus.OK);
    }
  
  
     
    //-------------------Retrieve Single User--------------------------------------------------------
      
    @RequestMapping(value = "/salespartlist/{salesPartId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalesPart> getUser(@PathVariable("salesPartId") String salesPartId) {
        System.out.println("Fetching Sales Part with id " + salesPartId);
        SalesPart salesPart = salesPartService.getSalesPartById(salesPartId);
        if (salesPart == null) {
            System.out.println("Sales Part with id " + salesPartId + " not found");
            return new ResponseEntity<SalesPart>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SalesPart>(salesPart, HttpStatus.OK);
    }
  
      
      
    //-------------------Create a User--------------------------------------------------------
      
    @RequestMapping(value = "/salespartlist/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSalesPart(@RequestBody SalesPart salesPart,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating salesPart " + salesPart.getdescription());
  
        //if (salesPartService.isUserExist(salesPart)) {
           // System.out.println("A Sales Part with name " + salesPart.getUsername() + " already exist");
           // return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        //}
  
        salesPartService.addSalesPart(salesPart);
  
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/salespartlist/{salesPartId}").buildAndExpand(salesPart.getsalesPartId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
  
     
      
    //------------------- Update a User --------------------------------------------------------
      
    @RequestMapping(value = "/user/{salesPartId}", method = RequestMethod.PUT)
    public ResponseEntity<SalesPart> updateUser(@PathVariable("salesPartId") String salesPartId, @RequestBody SalesPart salesPart) {
        System.out.println("Updating SalesPart " + salesPartId);
          
        SalesPart currentSalesPart = salesPartService.getSalesPartById(salesPartId);
          
        if (currentSalesPart==null) {
            System.out.println("salesPart with id " + salesPartId + " not found");
            return new ResponseEntity<SalesPart>(HttpStatus.NOT_FOUND);
        }
  
        currentSalesPart.setdescription(salesPart.getdescription());
        //currentSalesPart.setAddress(salesPart.getAddress());
        //currentSalesPart.setEmail(salesPart.getEmail());
          
        salesPartService.updateSalesPart(currentSalesPart);
        return new ResponseEntity<SalesPart>(currentSalesPart, HttpStatus.OK);
    }
  
     
    /* 
    //------------------- Delete a User --------------------------------------------------------
      
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SalesPart> deleteUser(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting User with id " + id);
  
        User user = salesPartService.findById(id);
        if (user == null) {
            System.out.println("Unable to delete. User with id " + id + " not found");
            return new ResponseEntity<SalesPart>(HttpStatus.NOT_FOUND);
        }
  
        salesPartService.deleteUserById(id);
        return new ResponseEntity<SalesPart>(HttpStatus.NO_CONTENT);
    }
  
      
     
    //------------------- Delete All Users --------------------------------------------------------
      
    @RequestMapping(value = "/user/", method = RequestMethod.DELETE)
    public ResponseEntity<SalesPart> deleteAllUsers() {
        System.out.println("Deleting All Users");
  
        salesPartService.deleteAllUsers();
        return new ResponseEntity<SalesPart>(HttpStatus.NO_CONTENT);
    }*/
  
}
