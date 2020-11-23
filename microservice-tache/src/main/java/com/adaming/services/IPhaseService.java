package com.adaming.services;

import java.util.List;

import com.adaming.entities.Phase;
import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
public interface IPhaseService {

	List<Phase> getAll();

	List<Phase> getAllNotTermined();

	Phase findOne(Long id);

	Phase save(Phase pIn);

	void delete(Long id);

	Phase update(Long id, Phase pIn);

	List<Phase> findByTache(Tache tache);
}
