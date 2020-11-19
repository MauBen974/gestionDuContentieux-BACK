package com.adaming.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.adaming.beans.UtilisateurBean;

@FeignClient(name = "microservice-utilisateur") 
//@RibbonClient(name = "microservice-utilisateur")
public interface MicroServiceUtilisateurProxies {
	
	@GetMapping("/utilisateurs")
	List<UtilisateurBean> fIndIfArchiveFalse();

}
