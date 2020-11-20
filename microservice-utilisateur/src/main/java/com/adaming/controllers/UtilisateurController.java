package com.adaming.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.dto.UtilisateurDTO;
import com.adaming.entities.Utilisateur;
import com.adaming.mapper.IUtilisateurMapper;
import com.adaming.services.IUtilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {

	@Autowired
	IUtilisateurService utilisateurService;
	@Autowired
	IUtilisateurMapper utilisateurMapper;

	@GetMapping("/utilisateurs-archives")
	public List<UtilisateurDTO> findAll() {
		return (List<UtilisateurDTO>) utilisateurService.findAll().stream()
				.map(u -> utilisateurMapper.convertToUtilisateurDTO(u)).collect(Collectors.toList());
	}

	@GetMapping("/utilisateurs")
	public List<UtilisateurDTO> findIfAchiveFalse() {
		return (List<UtilisateurDTO>) utilisateurService.findAllIfArchiveFalse().stream()
				.map(u -> utilisateurMapper.convertToUtilisateurDTO(u)).collect(Collectors.toList());
	}

	@GetMapping("/utilisateurs-archives/{idUtilisateur}")
	public Optional<UtilisateurDTO> findOne(@PathVariable("idUtilisateur") Long id) {
		return utilisateurMapper.convertToUtilisateurDTO(utilisateurService.findOne(id));
	}

	@GetMapping("/utilisateurs/{idUtilisateur}")
	public Optional<UtilisateurDTO> findOneIfAchiveFalse(@PathVariable("idUtilisateur") Long id) {
		return utilisateurMapper.convertToUtilisateurDTO(utilisateurService.findOneIfAchiveFalse(id));
	}

	@PostMapping("/utilisateurs")
	public UtilisateurDTO saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurMapper.convertToUtilisateurDTO(utilisateurService.saveUtilisateur(utilisateur));
	}

	@PostMapping("/utilisateurs/{idUtilisateur}")
	public UtilisateurDTO archiveUtilisateur(@PathVariable("idUtilisateur") Long id) {
		return utilisateurMapper.convertToUtilisateurDTO(utilisateurService.archiveUtilisateur(id));
	}

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		utilisateurService.deleteUtilisateur(id);
	}

	@GetMapping("/authentification")
	public Optional<UtilisateurDTO> authentification(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		return utilisateurMapper.convertToUtilisateurDTO(utilisateurService.authentification(email, password));
	}

}
