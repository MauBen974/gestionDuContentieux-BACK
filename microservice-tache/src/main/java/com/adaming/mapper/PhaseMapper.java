package com.adaming.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import com.adaming.dto.PhaseDTO;
import com.adaming.entities.Phase;

/**
 * @author VITTOZ Guillaume
 *
 */
@Component
public class PhaseMapper implements IPhaseMapper {

	ModelMapper modelMapper = new ModelMapper();

	@Override
	public PhaseDTO convertToPhaseDTO(Phase phase) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		PhaseDTO phaseDTO = modelMapper.map(phase, PhaseDTO.class);
		return phaseDTO;
	}

	@Override
	public Phase convertToPhase(PhaseDTO phaseDTO) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		Phase phase = modelMapper.map(phaseDTO, Phase.class);
		return phase;
	}
}
