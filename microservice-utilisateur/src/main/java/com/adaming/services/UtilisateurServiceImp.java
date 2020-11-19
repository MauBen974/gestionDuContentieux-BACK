package com.adaming.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entity.Utilisateur;
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
	public Optional<Utilisateur> authentification(String email, String password) {
		return utilisateurRepo.authentification(email, password);
	}

}
