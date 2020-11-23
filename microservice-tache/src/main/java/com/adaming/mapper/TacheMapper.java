package com.adaming.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.adaming.dto.TacheDTO;
import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
@Component
public class TacheMapper implements ITacheMapper {

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public TacheDTO convertToTacheDTO(Tache tache) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		TacheDTO tacheDTO = modelMapper.map(tache, TacheDTO.class);
		return tacheDTO;
	}

	@Override
	public Tache convertToTache(TacheDTO tacheDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Tache tache = modelMapper.map(tacheDTO, Tache.class);
		return tache;
	}

}
