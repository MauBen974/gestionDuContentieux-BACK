package com.adaming.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.dto.DocumentDTO;
import com.adaming.entities.Affaire;
import com.adaming.entities.Document;
import com.adaming.mapper.IDocumentMapper;
import com.adaming.repositories.IDocumentRepository;
import com.adaming.services.IDocumentService;

@RestController
@CrossOrigin("*")
public class DocumentController {
	@Autowired
	IDocumentService iDocumentService;
	@Autowired
	IDocumentRepository iDocumentRepository;
	@Autowired
	IDocumentMapper documentMapper;

	@GetMapping("/document")
	public List<DocumentDTO> findAll() {
		return (List<DocumentDTO>) iDocumentService.findAll().stream().map(e -> documentMapper.convertToDocumentDTO(e))
				.collect(Collectors.toList());
	}

	@GetMapping("/document/{id}")
	public Optional<DocumentDTO> findOne(@PathVariable Long id) {
		return documentMapper.convertToDocumentDTO(iDocumentService.findOne(id));
	}

	@GetMapping("/chercherDocParAffaire/{codeaff}")
	public List<DocumentDTO> chercherDocParAffaire(@PathVariable(value = "codeaff") Affaire codeaff) {
		return (List<DocumentDTO>) iDocumentRepository.chercherDocParAffaire(codeaff).stream()
				.map(e -> documentMapper.convertToDocumentDTO(e)).collect(Collectors.toList());
	}

	@GetMapping(value = "/docNonArchive/{nonArchive}")
	public List<DocumentDTO> findIfArchiveFalse(@PathVariable(value = "nonArchive") String nonArchive) {
		return (List<DocumentDTO>) iDocumentRepository.findIfArchiveFalse(nonArchive).stream()
				.map(e -> documentMapper.convertToDocumentDTO(e)).collect(Collectors.toList());
	}

	@PostMapping("/document")
	public DocumentDTO save(@RequestBody Document document) {
		return documentMapper.convertToDocumentDTO(iDocumentService.save(document));
	}

	@PutMapping("/document/{id}")
	public DocumentDTO MiseAJour(@PathVariable Long id, @RequestBody Document d) {
		d.setId(id);
		d.setDateCreation(d.getDateCreation());
		d.setNom(d.getNom());
		d.setDescription(d.getDescription());
		d.setArchive(d.isArchive());
		d.setAffaire(d.getAffaire());
		return documentMapper.convertToDocumentDTO(iDocumentRepository.save(d));
	}

	@DeleteMapping("/document/{id}")
	public String delete(@PathVariable Long id) {
		iDocumentService.delete(id);
		return "Le document a bien été suprimé";
	}

}
