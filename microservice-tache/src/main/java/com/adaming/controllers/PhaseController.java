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

import com.adaming.dto.PhaseDTO;
import com.adaming.entities.Phase;
import com.adaming.mapper.PhaseMapper;
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

	@Autowired
	private PhaseMapper phaseMapper;

	@GetMapping(value = "/phases")
	public List<PhaseDTO> getAll() {
		return (List<PhaseDTO>) servPhase.getAll().stream().map(e -> phaseMapper.convertToPhaseDTO(e))
				.collect(Collectors.toList());
	}

	@GetMapping(value = "/phases/{pId}")
	public PhaseDTO findOne(@PathVariable(value = "pId") Long id) {
		return phaseMapper.convertToPhaseDTO(servPhase.findOne(id));
	}

	@PostMapping(value = "/phases")
	public PhaseDTO save(@RequestBody Phase pIn) {
		return phaseMapper.convertToPhaseDTO(servPhase.save(pIn));
	}

	@DeleteMapping(value = "phases/{pId}")
	public void delete(@PathVariable(value = "pId") Long id) {
		servPhase.delete(id);
	}

	@PutMapping(value = "phases/{pId}")
	public PhaseDTO update(@PathVariable(value = "pId") Long id, @RequestBody Phase pIn) {
		Phase pOut = servPhase.findOne(id);

		pOut.setLibellePhase(pOut.getLibellePhase());
		pOut.setTaches(pIn.getTaches());
		pOut.setDateDebut(pIn.getDateDebut());
		pOut.setDateFin(pIn.getDateFin());

		return phaseMapper.convertToPhaseDTO(servPhase.save(pOut));
	}

}
