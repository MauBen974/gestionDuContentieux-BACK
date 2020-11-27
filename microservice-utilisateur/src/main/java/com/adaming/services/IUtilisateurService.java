package com.adaming.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adaming.entities.Utilisateur;

public interface IUtilisateurService {

	List<Utilisateur> findAll();
	List<Utilisateur> findAllIfArchiveFalse();
	Optional<Utilisateur> findOne(Long id);
	Optional<Utilisateur> findOneIfAchiveFalse(Long id);
	Utilisateur saveUtilisateur(Utilisateur utilisateur);
	String saveUtilisateurImage(String nom, String prenom, String email, String password,
			String role, MultipartFile file);
	void deleteUtilisateur(Long id);
	Utilisateur archiveUtilisateur(Long id);
	Optional<Utilisateur> authentification(String email, String password);
	
}
