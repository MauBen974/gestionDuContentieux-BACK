package com.adaming.services;

import java.util.List;

import com.adaming.entities.Phase;

public interface IPhaseService {

	List<Phase> getAll();

	Phase findOne(Long id);

	Phase save(Phase pIn);

	void delete(Long id);
}
