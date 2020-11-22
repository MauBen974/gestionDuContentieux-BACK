package com.adaming.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.dto.TacheDTO;
import com.adaming.entities.Tache;
import com.adaming.mapper.TacheMapper;
import com.adaming.services.ITacheService;

/**
 * @author VITTOZ Guillaume
 *
 */
@RestController
@CrossOrigin
public class TacheController {

	@Autowired
	private ITacheService servTache;

	@Autowired
	private TacheMapper tacheMapper;

	@GetMapping(value = "/taches")
	public List<TacheDTO> getAll() {
		return (List<TacheDTO>) servTache.getAll().stream().map(e -> tacheMapper.convertToTacheDTO(e))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/tachesById/{tId}")
	public TacheDTO findOne(@PathVariable(value = "tId") Long id) {
		return tacheMapper.convertToTacheDTO(servTache.findOne(id));
	}

	@PostMapping(value = "/taches")
	public TacheDTO save(@RequestBody Tache tIn) {
		return tacheMapper.convertToTacheDTO(servTache.save(tIn));
	}

	@DeleteMapping(value = "taches/{tId}")
	public void delete(@PathVariable(value = "tId") Long id) {
		servTache.delete(id);
	}

	@PutMapping(value = "taches/{tId}")
	public TacheDTO update(@PathVariable(value = "tId") Long id, @RequestBody Tache tIn) {
		Tache tOut = servTache.findOne(id);

		tOut.setTitreTache(tIn.getTitreTache());
		tOut.setDescriptionTache(tIn.getDescriptionTache());
		tOut.setDateCreation(tIn.getDateCreation());
		tOut.setStatusAudience(tIn.getStatusAudience());

		return tacheMapper.convertToTacheDTO(servTache.save(tOut));
	}

	@GetMapping(value = "tachesLibelle/{libellePhase}")
	public List<TacheDTO> findBylibellePhase(@PathVariable(value = "libellePhase") String libellePhase) {
		return (List<TacheDTO>) servTache.findBylibellePhase(libellePhase).stream()
				.map(e -> tacheMapper.convertToTacheDTO(e)).collect(Collectors.toList());
	}

	@GetMapping(value = "tachesAudience/{statusAudience}")
	public List<TacheDTO> findByStatusAudience(@PathVariable(value = "statusAudience") Boolean statusAudience) {
		return (List<TacheDTO>) servTache.findByStatusAudience(statusAudience).stream()
				.map(e -> tacheMapper.convertToTacheDTO(e)).collect(Collectors.toList());
	}
}
