package com.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entities.Phase;
import com.adaming.repositories.IPhaseRepository;

/**
 * @author VITTOZ Guillaume
 *
 */
@Service
public class PhaseServiceImpl implements IPhaseService {

	@Autowired
	private IPhaseRepository repoPhase;

	@Override
	public List<Phase> getAll() {
		return repoPhase.findAll();
	}

	@Override
	public Phase findOne(Long id) {
		return repoPhase.getOne(id);
	}

	@Override
	public Phase save(Phase pIn) {
		return repoPhase.save(pIn);
	}

	@Override
	public void delete(Long id) {
		repoPhase.deleteById(id);

	}
}
