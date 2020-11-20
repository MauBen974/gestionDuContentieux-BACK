package com.adaming.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entities.Tribunal;
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
		tribunal.setArchive(false);
		return tribunalRepository.save(tribunal);
	}

	@Override
	public void delete(Long id) {
		tribunalRepository.deleteById(id);
	}

	@Override
	public Tribunal setArchiveTrue(Long id) {
		Optional<Tribunal> optionalTribunal = tribunalRepository.findById(id);
		if (optionalTribunal.isPresent()) {
			Tribunal tribunal = optionalTribunal.get();
			tribunal.setArchive(true);
			tribunalRepository.save(tribunal);
			return tribunal;
		}
		return null;
	}

	@Override
	public List<Tribunal> findAllTribunalArchiveFalse() {
		return tribunalRepository.findAllTribunalByArchiveFalse();
	}

	@Override
	public List<Tribunal> findAllTribunalArchiveTrue() {
		return tribunalRepository.findAllTribunalByArchiveTrue();
	}

}
