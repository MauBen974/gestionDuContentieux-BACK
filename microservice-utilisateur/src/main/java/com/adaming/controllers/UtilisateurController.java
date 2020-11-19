package com.adaming.controllers;

import java.util.List;
import java.util.Optional;

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

import com.adaming.entity.Utilisateur;
import com.adaming.services.IUtilisateurService;

@RestController
@CrossOrigin
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
	public Utilisateur findOne(@PathVariable("idUtilisateur") Long id) {
		return utilisateurService.findOne(id);
	}

	@GetMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur findOneIfAchiveFalse(@PathVariable("idUtilisateur") Long id) {
		return utilisateurService.findOneIfAchiveFalse(id);
	}

	@PostMapping("/utilisateurs")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.saveUtilisateur(utilisateur);
	}

	@PostMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur archiveUtilisateur(@PathVariable("idUtilisateur") Long id) {
		return utilisateurService.archiveUtilisateur(id);
	}

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		utilisateurService.deleteUtilisateur(id);
	}

	@GetMapping("/authentification")
	public Utilisateur authentification(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		return utilisateurService.authentification(email, password);
	}

}
