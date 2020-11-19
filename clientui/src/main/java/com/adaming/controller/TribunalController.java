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

import com.adaming.beans.TribunalBean;
import com.adaming.proxies.MicroServiceTribunalProxies;

@RestController
@CrossOrigin
public class TribunalController {

	@Autowired
	private MicroServiceTribunalProxies microserviceTribunalProxies;

	@GetMapping("/tribunal")
	public List<TribunalBean> findAll() {
		return microserviceTribunalProxies.findAll();
	}

	@GetMapping("/tribunal/{id}")
	public Optional<TribunalBean> findOne(@PathVariable(name = "id") Long id) {
		return microserviceTribunalProxies.findOne(id);
	}

	@PostMapping("/tribunal")
	public TribunalBean saveOrUpdate(@RequestBody TribunalBean tribunal) {
		return microserviceTribunalProxies.saveOrUpdate(tribunal);
	}

	@DeleteMapping("/tribunal/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		microserviceTribunalProxies.delete(id);
	}

}
