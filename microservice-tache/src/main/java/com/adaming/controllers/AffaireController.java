package com.adaming.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.dto.AffaireDTO;
import com.adaming.entities.Affaire;
import com.adaming.mapper.IAffaireMapper;
import com.adaming.repositories.IAffaireRepository;
import com.adaming.services.IAffaireService;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin("*")
public class AffaireController {

	@Autowired
	IAffaireService iAffaireService;
	
	@Autowired
	IAffaireRepository iAffaireRepository;
	
	@Autowired
	IAffaireMapper affaireMapper;
	
	@GetMapping("/affaire")
	public List<AffaireDTO> findAll(){
		return (List<AffaireDTO>) iAffaireService.findAll().stream()		
		.map(e->affaireMapper.convertToAffaireDTO(e))
		.collect(Collectors.toList());
	}

	@GetMapping("/affaire/{id}")
	public Optional<AffaireDTO> findOne(@PathVariable Long id) {
		return affaireMapper.convertToAffaireDTO(iAffaireService.findOne(id));
	}
	
	@GetMapping("/affaireParStatus/{quelstatus}")
	public List<AffaireDTO> findByStatus(@PathVariable String quelstatus){
		return (List<AffaireDTO>) iAffaireRepository.findByStatus(quelstatus)
				.stream()		
				.map(e->affaireMapper.convertToAffaireDTO(e))
				.collect(Collectors.toList());
	}

	@PostMapping("/affaire")
	public AffaireDTO save(@RequestBody Affaire affaire) {
		return affaireMapper.convertToAffaireDTO(iAffaireService.save(affaire));
	}
	
	@PutMapping("/affaire/{id}")
	public AffaireDTO MiseAJour(@PathVariable Long id,@RequestBody Affaire a){
		a.setIdAffaire(id);
		a.setReferenceAffaire(a.getReferenceAffaire());
		a.setDescriptionAffaire(a.getDescriptionAffaire());
		a.setTitreAffaire(a.getTitreAffaire());
		a.setStatus(a.getStatus());
		a.setDocument(a.getDocument());
		return affaireMapper.convertToAffaireDTO(iAffaireRepository.save(a));
		
	}

	@DeleteMapping("/affaire/{id}")
	public String delete(@PathVariable Long id) {
		iAffaireService.delete(id);
		return "Cette affaire a bien été suprimée de la base de donnée";
	}
	
	
}
