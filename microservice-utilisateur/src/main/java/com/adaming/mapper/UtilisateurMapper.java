package com.adaming.mapper;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.adaming.dto.UtilisateurDTO;
import com.adaming.entities.Utilisateur;

@Component
public class UtilisateurMapper implements IUtilisateurMapper {

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public UtilisateurDTO convertToUtilisateurDTO(Utilisateur utilisateur) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		UtilisateurDTO utilisateurDto = modelMapper.map(utilisateur, UtilisateurDTO.class);
		return utilisateurDto;
	}

	@Override
	public Optional<UtilisateurDTO> convertToUtilisateurDTO(Optional<Utilisateur> utilisateur) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<UtilisateurDTO> utilisateurDto = modelMapper.map(utilisateur, Optional.class);
		return utilisateurDto;
	}

	@Override
	public Utilisateur convertToUtilisateur(UtilisateurDTO utilisateurDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Utilisateur utilisateur = modelMapper.map(utilisateurDTO, Utilisateur.class);
		return utilisateur;
	}

}
