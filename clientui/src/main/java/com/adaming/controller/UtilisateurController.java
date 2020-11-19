package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.beans.UtilisateurBean;
import com.adaming.proxies.MicroServiceUtilisateurProxies;

@RestController
@CrossOrigin
public class UtilisateurController {
	
	@Autowired
	private MicroServiceUtilisateurProxies microserviceUtilisateurProxies;
	
	@GetMapping("/utilisateurs")
	public List<UtilisateurBean> findIfArchiveFalse(){
		return microserviceUtilisateurProxies.fIndIfArchiveFalse();
	}

}
