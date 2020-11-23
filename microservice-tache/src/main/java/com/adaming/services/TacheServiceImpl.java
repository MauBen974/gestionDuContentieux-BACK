package com.adaming.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entities.Tache;
import com.adaming.repositories.ITacheRepository;

/**
 * @author VITTOZ Guillaume
 *
 */
@Service
public class TacheServiceImpl implements ITacheService {

	@Autowired
	private ITacheRepository repoTache;

	@Override
	public List<Tache> getAll() {
		return repoTache.findAll();
	}

	@Override
	@Transactional
	public Tache findOne(Long id) {
		return repoTache.getOne(id);
	}

	@Override
	public Tache save(Tache tIn) {
		return repoTache.save(tIn);
	}

	@Override
	public void delete(Long id) {
		repoTache.deleteById(id);
	}

	@Override
	public List<Tache> findBylibellePhase(String libellePhase) {
		return repoTache.findBylibellePhase(libellePhase);
	}

	@Override
	public List<Tache> findByStatusAudience(Boolean statusAudience) {
		return repoTache.findByStatusAudience(statusAudience);
	}

	@Override
	public List<Tache> findByIdUtilisateur(Long id) {
		return repoTache.findByIdUtilisateur(id);
	}

}
