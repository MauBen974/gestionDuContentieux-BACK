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

import com.adaming.beans.AffaireBean;
import com.adaming.proxies.MicroServiceTacheProxies;

@RestController
@CrossOrigin
public class PhaseController {
	
	@Autowired
	private MicroServiceTacheProxies microserviceTacheProxies;
	
	@GetMapping("/affaire")
	public List<AffaireBean> findAll(){
		return microserviceTacheProxies.findAll();
	}

	@GetMapping("/affaire/{id}")
	public Optional<AffaireBean> findOne(@PathVariable Long id){
		return microserviceTacheProxies.findOne(id);
	}
	
	@GetMapping("/affaireParStatus/{quelstatus}")
	public List<AffaireBean> findByStatus(@PathVariable String quelstatus){
		return microserviceTacheProxies.findByStatus(quelstatus);
	}

	@PostMapping("/affaire")
	public AffaireBean save(@RequestBody Affaire affaire){
		return microserviceTacheProxies.save(affaire);
	}
	
	@PutMapping("/affaire/{id}")
	public AffaireBean MiseAJour(@PathVariable Long id,@RequestBody Affaire a){
		return microserviceTacheProxies.MiseAJour(a);
	}

	@DeleteMapping("/affaire/{id}")
	public String delete(@PathVariable Long id){
		microserviceTacheProxies.delete(id);
			return "Cette affaire a bien été suprimée de la base de donnée";
	}

}
