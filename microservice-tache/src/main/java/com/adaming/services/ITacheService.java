package com.adaming.services;

import java.util.List;

import javax.transaction.Transactional;

import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
public interface ITacheService {

	List<Tache> getAll();

	@Transactional
	Tache findOne(Long id);

	Tache save(Tache tIn);

	void delete(Long id);

	List<Tache> findBylibellePhase(String libellePhase);

	List<Tache> findByStatusAudience(Boolean statusAudience);
	
	List<Tache> findByIdUtilisateur(Long id);
	
}
