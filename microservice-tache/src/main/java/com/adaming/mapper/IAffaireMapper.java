package com.adaming.mapper;

import java.util.Optional;

import com.adaming.dto.AffaireDTO;
import com.adaming.entities.Affaire;

public interface IAffaireMapper {
	AffaireDTO convertToAffaireDTO(Affaire affaire);
	Affaire convertToAffaire(AffaireDTO affaireDTO);

	Optional<AffaireDTO> convertToAffaireDTO(Optional<Affaire> affaire);
}
