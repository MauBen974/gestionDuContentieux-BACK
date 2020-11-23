package com.adaming.mapper;

import java.util.Optional;

import com.adaming.dto.TribunalDTO;
import com.adaming.entities.Tribunal;

public interface ITribunalMapper {
	
	TribunalDTO convertToTribunalDTO(Tribunal tribunal);
	
	Optional<TribunalDTO> convertToOptionalTribunalDTO(Optional<Tribunal> tribunal);
	
	Tribunal convertToTribunal(TribunalDTO tribunalDTO);

}
