package com.adaming.mapper;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.adaming.dto.TribunalDTO;
import com.adaming.entities.Tribunal;

@Component
public class TribunalMapper implements ITribunalMapper {

	ModelMapper modelMapper = new ModelMapper();
	
	
	@Override
	public TribunalDTO convertToTribunalDTO(Tribunal tribunal) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(tribunal, TribunalDTO.class);
	}

	@Override
	public Tribunal convertToTribunal(TribunalDTO tribunalDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(tribunalDTO, Tribunal.class);
	}

	@Override
	public Optional<TribunalDTO> convertToOptionalTribunalDTO(Optional<Tribunal> tribunal) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(tribunal, Optional.class);
	}

}
