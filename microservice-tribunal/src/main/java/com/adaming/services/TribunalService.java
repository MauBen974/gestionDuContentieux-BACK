package com.adaming.services;

import java.util.List;
import java.util.Optional;

import com.adaming.entities.Tribunal;

public interface TribunalService {
	
	public List<Tribunal> findAll();
	public Optional<Tribunal> findById(Long id);
	public Tribunal save(Tribunal tribunal);
	public void delete(Long id);

}
