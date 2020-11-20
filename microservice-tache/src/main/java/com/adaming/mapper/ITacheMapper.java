package com.adaming.mapper;

import com.adaming.dto.TacheDTO;
import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
public interface ITacheMapper {

	TacheDTO convertToTacheDTO(Tache tache);

	Tache convertToTache(TacheDTO tacheDTO);
}
