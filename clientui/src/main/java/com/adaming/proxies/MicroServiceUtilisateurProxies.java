package com.adaming.proxies;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.adaming.beans.UtilisateurBean;

@FeignClient(name = "microservice-utilisateur")
@RibbonClient(name = "microservice-utilisateur")
public interface MicroServiceUtilisateurProxies {

	@GetMapping("/utilisateurs-archives")
	List<UtilisateurBean> findAll();

	@GetMapping("/utilisateurs")
	List<UtilisateurBean> findIfArchiveFalse();

	@GetMapping("/utilisateurs-archives/{idUtilisateur}")
	Optional<UtilisateurBean> findOne(@PathVariable("idUtilisateur") Long id);

	@GetMapping("/utilisateurs/{idUtilisateur}")
	Optional<UtilisateurBean> findOneIfAchiveFalse(@PathVariable("idUtilisateur") Long id);

	@PostMapping("/utilisateurs")
	UtilisateurBean saveUtilisateur(@RequestBody UtilisateurBean utilisateur);

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	void deleteUtilisateur(@PathVariable("idUtilisateur") Long id);

	@PostMapping("/utilisateurs/{idUtilisateur}")
	UtilisateurBean archiveUtilisateur(@PathVariable("idUtilisateur") Long id);

	@GetMapping("/authentification")
	Optional<UtilisateurBean> authentification(@RequestParam("email") String email,
			@RequestParam("password") String password);
}
