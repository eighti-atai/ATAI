package com.atai.unter.module.enterprise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atai.unter.module.enterprise.model.User;
import com.atai.unter.module.enterprise.service.UserService;
import com.atai.unter.module.order.model.SalesPart;
import com.atai.unter.module.order.service.SalesPartService;

@RestController
public class UserController {
	
	
	@Autowired
    UserService userService ;  //Service which will do all data retrieval/manipulation work
  
	
	//-------------------Retrieve Single User--------------------------------------------------------
    
    @RequestMapping(value = "/User/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId) {
        System.out.println("Fetching Sales Part with id " + userId);
        User user = userService.getUserById(userId);
        if (userId == null) {
            System.out.println("Sales Part with id " + userId + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
  

}
