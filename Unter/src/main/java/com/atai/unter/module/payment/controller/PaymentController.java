package com.atai.unter.module.payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atai.unter.generic.controller.AbstractController;
import com.atai.unter.module.payment.model.Payment;
import com.atai.unter.module.payment.service.PaymentService;

@RestController
public class PaymentController extends AbstractController<Integer, Payment>{

	@Autowired
	public PaymentController(PaymentService service) {
		super(service, Integer.class, "payments");
		// TODO Auto-generated constructor stub
	}

	@Override
	@GetMapping(value = "/payments")
	public ModelAndView init(Model model) {
		// TODO Auto-generated method stub
		return super.init(model);
	}

	@Override
	@GetMapping(value = "/Payment")
	public ResponseEntity<List<Payment>> list() {
		// TODO Auto-generated method stub
		return super.list();
	}

	@Override
	@PostMapping(value = "/Payment")
	public ResponseEntity<Void> add(@RequestBody Payment object) {
		// TODO Auto-generated method stub
		return super.add(object);
	}

	@Override
	@PutMapping(value = "/Payment")
	public ResponseEntity<Payment> modify(@RequestBody Payment newObject) {
		// TODO Auto-generated method stub
		return super.modify(newObject);
	}

	@Override
	@DeleteMapping(value = "/Payment/{objid:.+}")
	public ResponseEntity<Payment> delete(@PathVariable String objid) {
		// TODO Auto-generated method stub
		return super.delete(objid);
	}

	@Override
	@PostMapping(value = "/Payment/Search")
	public ResponseEntity<List<Payment>> search(@RequestBody Payment object) {
		// TODO Auto-generated method stub
		return super.search(object);
	}

	
}
