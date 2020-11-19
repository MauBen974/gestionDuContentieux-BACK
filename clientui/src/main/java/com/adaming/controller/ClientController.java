package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.beans.TribunalBean;
import com.adaming.proxies.MicroServiceTribunalProxies;

@RestController
@CrossOrigin
public class ClientController {

	@Autowired
	private MicroServiceTribunalProxies microserviceTribunalProxies;
	
	@GetMapping("/tribunal")
	public List<TribunalBean> findAll() {
		return microserviceTribunalProxies.findAll();
	}
	
}
