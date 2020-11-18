package com.adaming.services;

import java.util.List;

import com.adaming.entities.Tache;

/**
 * @author VITTOZ Guillaume
 *
 */
public interface ITacheService {

	List<Tache> getAll();

	Tache findOne(Long id);

	Tache save(Tache tIn);

	void delete(Long id);
}
