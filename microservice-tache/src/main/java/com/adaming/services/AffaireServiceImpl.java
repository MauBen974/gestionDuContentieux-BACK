package com.adaming.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entities.Affaire;
import com.adaming.repositories.IAffaireRepository;
@Service
public class AffaireServiceImpl implements IAffaireService {
	@Autowired
	IAffaireRepository iAffaireRepository;
	
	@Override
	public List<Affaire> findAll() {
		return iAffaireRepository.findAll();
	}

	@Override
	public Optional<Affaire> findOne(Long id) {
		return iAffaireRepository.findById(id);
	}

	@Override
	public Affaire save(Affaire affaire) {
		return iAffaireRepository.save(affaire);
	}

	@Override
	public boolean delete(Long id) {
		iAffaireRepository.deleteById(id);
		return true;
	}

}
