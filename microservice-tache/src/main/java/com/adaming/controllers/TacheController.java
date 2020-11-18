package com.adaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Tache;
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

	@GetMapping(value = "/taches")
	public List<Tache> getAll() {
		return servTache.getAll();
	}

	@GetMapping(value = "/taches/{tId}")
	public Tache findOne(@PathVariable(value = "tId") Long id) {
		return servTache.findOne(id);
	}

	@PostMapping(value = "/taches")
	public Tache save(@RequestBody Tache tIn) {
		return servTache.save(tIn);
	}

	@DeleteMapping(value = "taches/{tId}")
	public void delete(@PathVariable(value = "tId") Long id) {
		servTache.delete(id);
	}

	@PutMapping(value = "taches/{pId}")
	public Tache update(@PathVariable(value = "tId") Long id, @RequestBody Tache tIn) {
		Tache tOut = servTache.findOne(id);

		tOut.setTitreTache(tIn.getTitreTache());
		tOut.setDescriptionTache(tIn.getDescriptionTache());
		tOut.setDateCreation(tIn.getDateCreation());
		tOut.setStatusAudience(tIn.getStatusAudience());
		tOut.setPhases(tIn.getPhases());

		return servTache.save(tOut);
	}
}
