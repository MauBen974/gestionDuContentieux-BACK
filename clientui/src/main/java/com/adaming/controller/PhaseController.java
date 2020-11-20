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
import com.adaming.proxies.MicroServiceTacheProxies;

@RestController
@CrossOrigin
public class PhaseController {
	
	@Autowired
	private MicroServiceTacheProxies microserviceTacheProxies;
	
	@GetMapping(value = "/phases")
	public List<PhaseBean> getAll(){
		return microserviceTacheProxies.getAllPhases();
	}

	@GetMapping(value = "/phases/{pId}")
	public PhaseBean findOne(@PathVariable(value = "pId") Long id) {
		return microserviceTacheProxies.findOnePhase(id);
	}

	@PostMapping(value = "/phases")
	public PhaseBean save(@RequestBody PhaseBean pIn) {
		return microserviceTacheProxies.savePhase(pIn);
	}

	@DeleteMapping(value = "/phases/{pId}")
	public void delete(@PathVariable(value = "pId") Long id) {
		microserviceTacheProxies.deletePhase(id);
	}

	@PutMapping(value = "/phases/{pId}")
	public PhaseBean update(@PathVariable(value = "pId") Long id, @RequestBody PhaseBean pIn) {
		return microserviceTacheProxies.updatePhase(id, pIn);
	}

}
