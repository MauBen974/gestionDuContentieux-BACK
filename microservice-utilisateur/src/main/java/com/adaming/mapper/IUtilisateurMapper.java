package com.adaming.mapper;

import java.util.Optional;

import com.adaming.dto.UtilisateurDTO;
import com.adaming.entities.Utilisateur;

public interface IUtilisateurMapper {

	UtilisateurDTO convertToUtilisateurDTO(Utilisateur utilisateur);
	Optional<UtilisateurDTO> convertToUtilisateurDTO(Optional<Utilisateur> utilisateur);
	Utilisateur convertToUtilisateur(UtilisateurDTO utilisateurDTO);
}
