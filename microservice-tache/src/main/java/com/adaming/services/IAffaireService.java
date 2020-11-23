package com.adaming.services;

import java.util.List;
import java.util.Optional;

import com.adaming.entities.Affaire;

public interface IAffaireService {

	List<Affaire> findAll();
	Optional<Affaire> findOne(Long id);
	Affaire save(Affaire affaire);
	boolean delete(Long id);
}
