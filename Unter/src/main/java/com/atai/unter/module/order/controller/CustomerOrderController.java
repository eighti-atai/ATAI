package com.atai.unter.module.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.generic.controller.AbstractController;
import org.springframework.security.core.userdetails.User;
import com.atai.unter.module.enterprise.service.SecurityService;
import com.atai.unter.module.enterprise.service.UserService;
import com.atai.unter.module.order.model.CustomerOrder;
import com.atai.unter.module.order.service.CustomerOrderService;

@Controller
public class CustomerOrderController extends AbstractController<String, CustomerOrder>{

	private final String initUrl = "/customerorders";
	private final String url = "/CustomerOrder";
	@Autowired
	SecurityService securityService;
	@Autowired
	UserService userService;
	
	@Autowired
	public CustomerOrderController(CustomerOrderService service) {
		super(service, String.class, "customerorders");
		// TODO Auto-generated constructor stub
	}

	@Override
	@GetMapping(value = initUrl)
	public ModelAndView init(Model model) {
		// TODO Auto-generated method stub
		return super.init(model);
	}

	@Override
	@GetMapping(value = url)
	public ResponseEntity<List<CustomerOrder>> list() {
		// TODO Auto-generated method stub
		return super.list();
	}

	@Override
	@PostMapping(value = url)
	public ResponseEntity<Void> add(@RequestBody CustomerOrder object) {
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String name = user.getUsername();
	    System.out.println("user Name: "+name);
	    com.atai.unter.module.enterprise.model.User currentUser = userService.findByUsername(name);  
		object.setUserId(currentUser.getId());
		return super.add(object);
	}

	@Override
	@PutMapping(value = url)
	public ResponseEntity<CustomerOrder> modify(@RequestBody CustomerOrder newObject) {
		// TODO Auto-generated method stub
		return super.modify(newObject);
	}

	@Override
	@DeleteMapping(value = "/CustomerOrder/{objid:.+}")
	public ResponseEntity<CustomerOrder> delete(@PathVariable("objid") String objid) {
		// TODO Auto-generated method stub
		return super.delete(objid);
	}

	@Override
	@PostMapping(value = "/CustomerOrder/Search")
	public ResponseEntity<List<CustomerOrder>> search(@RequestBody CustomerOrder object) {
		// TODO Auto-generated method stub
		return super.search(object);
	}

	
	
}
