package com.adaming.mapper;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.adaming.dto.AffaireDTO;
import com.adaming.entities.Affaire;
@Component
public class AffaireMapper implements IAffaireMapper{
	ModelMapper modelMapper	=new ModelMapper();
	@Override
	public AffaireDTO convertToAffaireDTO(Affaire affaire) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		AffaireDTO affaireDTO=modelMapper.map(affaire,AffaireDTO.class);

		return affaireDTO;
	}

	@Override
	public Affaire convertToAffaire(AffaireDTO affaireDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Affaire affaire=modelMapper.map(affaireDTO,Affaire.class);

			return affaire;	
	}
	
	@Override
	public Optional<AffaireDTO> convertToAffaireDTO(Optional<Affaire> affaire) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Optional<AffaireDTO> affaireDto = modelMapper.map(affaire, Optional.class);
		return affaireDto;
	}

}
