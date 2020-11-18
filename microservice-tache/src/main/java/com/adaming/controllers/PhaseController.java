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

import com.adaming.entities.Phase;
import com.adaming.services.IPhaseService;

/**
 * @author VITTOZ Guillaume
 *
 */
@RestController
@CrossOrigin
public class PhaseController {

	@Autowired
	private IPhaseService servPhase;

	@GetMapping(value = "/phases")
	public List<Phase> getAll() {
		return servPhase.getAll();
	}

	@GetMapping(value = "/phases/{pId}")
	public Phase findOne(@PathVariable(value = "pId") Long id) {
		return servPhase.findOne(id);
	}

	@PostMapping(value = "/phases")
	public Phase save(@RequestBody Phase pIn) {
		return servPhase.save(pIn);
	}

	@DeleteMapping(value = "phases/{pId}")
	public void delete(@PathVariable(value = "pId") Long id) {
		servPhase.delete(id);
	}

	@PutMapping(value = "phases/{pId}")
	public Phase update(@PathVariable(value = "pId") Long id, @RequestBody Phase pIn) {
		Phase pOut = servPhase.findOne(id);

		pOut.setLibellePhase(pOut.getLibellePhase());
		pOut.setTaches(pIn.getTaches());
		pOut.setDateDebut(pIn.getDateDebut());
		pOut.setDateFin(pIn.getDateFin());

		return servPhase.save(pOut);
	}
}
