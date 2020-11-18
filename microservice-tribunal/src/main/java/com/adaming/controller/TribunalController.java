package com.adaming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Tribunal;
import com.adaming.services.TribunalService;

@RestController
@CrossOrigin
public class TribunalController {
	
	@Autowired
	private TribunalService tribunalService;
	
	@GetMapping("/tribunal")
	public List<Tribunal> findAll() {
		return tribunalService.findAll();
	}
	
	@GetMapping("/tribunal/{id}")
	public Optional<Tribunal> findOne(@PathVariable(name = "id") Long id) {
		return tribunalService.findById(id);
	}
	
	@PostMapping("/tribunal")
	public Tribunal saveOrUpdate(@RequestBody Tribunal tribunal) {
		return tribunalService.save(tribunal);
	}
	
	@DeleteMapping("/tribunal/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		tribunalService.delete(id);
	}

}
