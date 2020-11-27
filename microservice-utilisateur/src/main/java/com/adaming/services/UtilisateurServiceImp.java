package com.adaming.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adaming.entities.Utilisateur;
import com.adaming.repositories.UtilisateurRepository;

@Service
public class UtilisateurServiceImp implements IUtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepo;

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepo.findAll();
	}

	@Override
	public List<Utilisateur> findAllIfArchiveFalse() {
		return utilisateurRepo.findAllIfArchiveFalse();
	}

	@Override
	public Optional<Utilisateur> findOne(Long id) {
		return utilisateurRepo.findById(id);
	}

	@Override
	public Optional<Utilisateur> findOneIfAchiveFalse(Long id) {
		return utilisateurRepo.findOneIfAchiveFalse(id);
	}

	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		utilisateur.setArchive(false);
		return utilisateurRepo.save(utilisateur);
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepo.deleteById(id);
	}

	@Override
	public Utilisateur archiveUtilisateur(Long id) {
		Utilisateur utilisateur = utilisateurRepo.findById(id).get();
		utilisateur.setArchive(true);
		return utilisateurRepo.save(utilisateur);
	}

	@Override
	public Optional<Utilisateur> authentification(String email, String password) {
		return utilisateurRepo.authentification(email, password);
	}

	@Override
	public String saveUtilisateurImage(String nom, String prenom, String email, String password, String role,
			MultipartFile file) {
		try {
			Utilisateur currentUser = new Utilisateur();
			currentUser.setNom(nom);
			currentUser.setPrenom(prenom);
			currentUser.setEmail(email);
			currentUser.setPassword(password);
			currentUser.setRole(role);
			currentUser.setImage(file.getBytes());
			utilisateurRepo.save(currentUser);
			return "File uploaded successfuly filname ="+file.getOriginalFilename();
		}
		catch(Exception ex){
			ex.printStackTrace();
			return "Fail ! check the file size";
		}
	}

}
