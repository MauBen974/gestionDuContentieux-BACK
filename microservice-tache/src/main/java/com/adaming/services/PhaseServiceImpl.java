package com.adaming.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entities.Phase;
import com.adaming.entities.Tache;
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

	@Override
	public List<Phase> getAllNotTermined() {
		return repoPhase.findAll().stream().filter((e) -> e.getDateFin() != null).collect(Collectors.toList());
	}

//	@Override
//	public Phase update(Long id, Phase pIn) {
//		Phase pOut = repoPhase.findById(id).get();
//
//		pOut.setLibellePhase(pIn.getLibellePhase());
//		pOut.setTache(pIn.getTache());
//		pOut.setDateDebut(pIn.getDateDebut());
//		pOut.setDateFin(pIn.getDateFin());
//		
//		return pOut;
//	}

	@Override
	public List<Phase> findByTache(Tache tache) {
		return repoPhase.findByTache(tache);
	}
	
	
	
	
}
