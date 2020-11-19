package com.adaming.services;

import java.util.List;
import java.util.Optional;

import com.adaming.entity.Utilisateur;

public interface IUtilisateurService {

	List<Utilisateur> findAll();
	List<Utilisateur> findAllIfArchiveFalse();
	Optional<Utilisateur> findOne(Long id);
	Optional<Utilisateur> findOneIfAchiveFalse(Long id);
	Utilisateur saveUtilisateur(Utilisateur utilisateur);
	void deleteUtilisateur(Long id);
	Optional<Utilisateur> authentification(String username, String password);
	
}
