package com.adaming.mapper;

import com.adaming.dto.PhaseDTO;
import com.adaming.entities.Phase;

/**
 * @author VITTOZ Guillaume
 *
 */
public interface IPhaseMapper {

	PhaseDTO convertToPhaseDTO(Phase phase);

	Phase convertToPhase(PhaseDTO phaseDTO);
}
