package com.adaming.services;

import java.util.List;
import java.util.Optional;

import com.adaming.entity.Utilisateur;

public interface IUtilisateurService {

	List<Utilisateur> findAll();
	List<Utilisateur> findAllIfArchiveFalse();
	Utilisateur findOne(Long id);
	Utilisateur findOneIfAchiveFalse(Long id);
	Utilisateur saveUtilisateur(Utilisateur utilisateur);
	void deleteUtilisateur(Long id);
	Utilisateur archiveUtilisateur(Long id);
	Utilisateur authentification(String username, String password);
	
}
