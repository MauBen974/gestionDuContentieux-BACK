package com.adaming.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entites.Tribunal;
import com.adaming.repositories.TribunalRepository;

@Service
public class TribunalServiceImpl implements TribunalService {
	
	@Autowired
	private TribunalRepository tribunalRepository;

	@Override
	public List<Tribunal> findAll() {
		return tribunalRepository.findAll();
	}

	@Override
	public Optional<Tribunal> findById(Long id) {
		return tribunalRepository.findById(id);
	}

	@Override
	public Tribunal save(Tribunal tribunal) {
		return tribunalRepository.save(tribunal);
	}

	@Override
	public void delete(Long id) {
		tribunalRepository.deleteById(id);
	}

}
