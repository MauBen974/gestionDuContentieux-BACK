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

import com.adaming.beans.DocumentBean;
import com.adaming.proxies.MicroServiceTacheProxies;

@RestController
@CrossOrigin
public class DocumentController {
	
	@Autowired
	private MicroServiceTacheProxies microserviceTacheProxies;
	
	@GetMapping("/document")
	public List<DocumentBean> findAll(){
		return microserviceTacheProxies.findAll();
	}

	@GetMapping("/document/{id}")
	public Optional<DocumentBean> findOne(@PathVariable Long id) {
		return microserviceTacheProxies.findOne(id);
	}

	@GetMapping("/chercherDocParAffaire/{codeaff}")
	public List<DocumentBean> chercherDocParAffaire(@PathVariable(value="codeaff") Affaire codeaff) {
		return microserviceTacheProxies.chercherDocParAffaire(codeaff);
	}

	@GetMapping(value = "/docNonArchive/{nonArchive}")
	public List<DocumentBean> findIfArchiveFalse(@PathVariable(value="nonArchive") Boolean nonArchive){
		return microserviceTacheProxies.findIfArchiveFalse(nonArchive);
	}

	@PostMapping("/document")
	public DocumentBean save(@RequestBody Document document) {
		return microserviceTacheProxies.save(document);
	}


	@PutMapping("/document/{id}")
	public DocumentBean MiseAJour(@PathVariable Long id,@RequestBody Document d){
	
	return microserviceTacheProxies.save(d);
	
	}

	@DeleteMapping("/document/{id}")
	public String delete(@PathVariable Long id){
		microserviceTacheProxies.delete(id);
		
		return "Le document a bien été suprimé";
	}

}
