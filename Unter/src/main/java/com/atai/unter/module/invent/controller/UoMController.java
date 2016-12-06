package com.atai.unter.module.invent.controller;

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
import com.atai.unter.module.invent.model.UoM;
import com.atai.unter.module.invent.service.UoMService;

@RestController
public class UoMController extends AbstractController<String, UoM>{
	
	@Autowired
	public UoMController(UoMService uoMService){
		super(uoMService, String.class, "uoMs");
	}

	@Override
	@GetMapping(value= "/uoMs")
	public ModelAndView init(Model model) {
		// TODO Auto-generated method stub
		return super.init(model);
	}

	@Override
	@GetMapping(value="/UoM")
	public ResponseEntity<List<UoM>> list() {
		// TODO Auto-generated method stub
		return super.list();
	}

	@Override
	@PostMapping(value="/UoM")
	public ResponseEntity<Void> add(@RequestBody UoM object) {
		// TODO Auto-generated method stub
		return super.add(object);
	}

	@Override
	@PutMapping(value="/UoM")
	public ResponseEntity<UoM> modify(@RequestBody UoM newObject) {
		// TODO Auto-generated method stub
		return super.modify(newObject);
	}

	@Override
	@DeleteMapping(value="/UoM/{objid:.+}")
	public ResponseEntity<UoM> delete(@PathVariable String objid) {
		// TODO Auto-generated method stub
		return super.delete(objid);
	}

	@Override
	@PostMapping(value="/UoM/Search")
	public ResponseEntity<List<UoM>> search(@RequestBody UoM object) {
		// TODO Auto-generated method stub
		return super.search(object);
	}
}
