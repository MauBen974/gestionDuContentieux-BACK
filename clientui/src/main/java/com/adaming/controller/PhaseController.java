package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.beans.PhaseBean;
import com.adaming.proxies.MicroServicePhaseProxies;

@RestController
@CrossOrigin
public class PhaseController {
	
	@Autowired
	private MicroServicePhaseProxies microservicePhaseProxies;
	
	@GetMapping(value = "/phases")
	public List<PhaseBean> getAll(){
		return microservicePhaseProxies.getAll();
	}

	@GetMapping(value = "/phases/{pId}")
	public PhaseBean findOne(@PathVariable(value = "pId") Long id) {
		return microservicePhaseProxies.findOne(id);
	}

	@PostMapping(value = "/phases")
	public PhaseBean save(@RequestBody PhaseBean pIn) {
		return microservicePhaseProxies.save(pIn);
	}

	@DeleteMapping(value = "phases/{pId}")
	public void delete(@PathVariable(value = "pId") Long id) {
		microservicePhaseProxies.delete(id);
	}

	@PutMapping(value = "phases/{pId}")
	public PhaseBean update(@PathVariable(value = "pId") Long id, @RequestBody PhaseBean pIn) {
		return microservicePhaseProxies.update(id, pIn);
	}

}
