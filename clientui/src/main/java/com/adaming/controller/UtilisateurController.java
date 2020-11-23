package com.adaming.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.beans.UtilisateurBean;
import com.adaming.proxies.MicroServiceUtilisateurProxies;

@RestController
@CrossOrigin
public class UtilisateurController {

	@Autowired
	private MicroServiceUtilisateurProxies microserviceUtilisateurProxies;

	@GetMapping("/utilisateurs")
	public List<UtilisateurBean> findIfArchiveFalse() {
		return microserviceUtilisateurProxies.findIfArchiveFalse();
	}

	@GetMapping("/utilisateurs-archives")
	List<UtilisateurBean> findAll() {
		return microserviceUtilisateurProxies.findAll();
	}

	@GetMapping("/utilisateurs-archives/{idUtilisateur}")
	Optional<UtilisateurBean> findOne(@PathVariable("idUtilisateur") Long id) {
		return microserviceUtilisateurProxies.findOne(id);
	}

	@GetMapping("/utilisateurs/{idUtilisateur}")
	Optional<UtilisateurBean> findOneIfAchiveFalse(@PathVariable("idUtilisateur") Long id) {
		return microserviceUtilisateurProxies.findOneIfAchiveFalse(id);
	}

	@PostMapping("/utilisateurs")
	UtilisateurBean saveUtilisateur(@RequestBody UtilisateurBean utilisateur) {
		return microserviceUtilisateurProxies.saveUtilisateur(utilisateur);
	}

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		microserviceUtilisateurProxies.deleteUtilisateur(id);
	}

	@PostMapping("/utilisateurs/{idUtilisateur}")
	UtilisateurBean archiveUtilisateur(@PathVariable("idUtilisateur") Long id) {
		return microserviceUtilisateurProxies.archiveUtilisateur(id);
	}

	@GetMapping("/authentification")
	Optional<UtilisateurBean> authentification(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		return microserviceUtilisateurProxies.authentification(email, password);
	}
}
