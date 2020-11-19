package com.adaming.controllers;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entity.Utilisateur;
import com.adaming.services.IUtilisateurService;

@RestController
public class UtilisateurController {
	
	@Autowired
	IUtilisateurService utilisateurService;
	
	@GetMapping("/utilisateurs-archives")
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@GetMapping("/utilisateurs")
	public List<Utilisateur> findIfAchiveFalse() {
		return utilisateurService.findAllIfArchiveFalse();
	}
	
	@GetMapping("/utilisateurs-archives/{idUtilisateur}")
	public Optional<Utilisateur> findOne(@PathParam("idUtilisateur") Long id) {
		return utilisateurService.findOne(id);
	}

	
	@GetMapping("/utilisateurs/{idUtilisateur}")
	public Optional<Utilisateur> findOneIfAchiveFalse(@PathParam("idUtilisateur") Long id) {
		return utilisateurService.findOneIfAchiveFalse(id);
	}

	@PostMapping("/utilisateurs")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.saveUtilisateur(utilisateur);
	}

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathParam("idUtilisateur") Long id) {
		utilisateurService.deleteUtilisateur(id);;
	}

	@GetMapping("/authentification")
	public Optional<Utilisateur> authentification(String username, String password) {
		return utilisateurService.authentification(username, password);
	}

}
