package com.adaming.controllers;

import java.time.LocalDate;
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
import com.adaming.dto.TacheDTO;
import com.adaming.entities.Phase;
import com.adaming.mapper.PhaseMapper;
import com.adaming.mapper.TacheMapper;
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

	@Autowired
	private TacheMapper tacheMapper;

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
	public PhaseDTO create(@RequestBody Phase pIn) {
		pIn.setDateFin(null);
		return phaseMapper.convertToPhaseDTO(servPhase.save(pIn));
	}

	@DeleteMapping(value = "/phases/{pId}")
	public void delete(@PathVariable(value = "pId") Long id) {
		servPhase.delete(id);
	}

	@PutMapping(value = "/phases/{pId}")
	public PhaseDTO updateSimple(@PathVariable(value = "pId") Long id, @RequestBody Phase pIn) {
		Phase pOut = servPhase.findOne(id);

		pOut.setLibellePhase(pIn.getLibellePhase());
		pOut.setTache(pIn.getTache());
		pOut.setDateDebut(pIn.getDateDebut());
		pOut.setDateFin(pIn.getDateFin());

		return phaseMapper.convertToPhaseDTO(servPhase.save(pOut));
	}

	@GetMapping(value = "/phasestermined")
	public List<PhaseDTO> getAllNotTermined() {
		return (List<PhaseDTO>) servPhase.getAllNotTermined().stream().map(e -> phaseMapper.convertToPhaseDTO(e))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/phases/getByTache")
	public List<PhaseDTO> findByTache(@RequestBody TacheDTO dto) {
		return servPhase.findByTache(tacheMapper.convertToTache(dto)).stream()
				.map(e -> phaseMapper.convertToPhaseDTO(e)).collect(Collectors.toList());
	}

	@PutMapping(value = "/phasesLibelle/{pId}")
	public PhaseDTO updateLibelle(@PathVariable(value = "pId") Long id, @RequestBody Phase phase) {
		Phase pOut = servPhase.findOne(id);

		pOut.setLibellePhase(pOut.getLibellePhase());
		pOut.setTache(pOut.getTache());
		pOut.setDateDebut(pOut.getDateDebut());
		pOut.setDateFin(LocalDate.now());
		phaseMapper.convertToPhaseDTO(servPhase.save(pOut));
		
		Phase pNew = new Phase(phase.getLibellePhase(),LocalDate.now(),null,pOut.getTache());
//		pNew.setTache(pOut.getTache());
//		pNew.setDateDebut(LocalDate.now());
//		pNew.setDateFin(null);
//		pNew.setLibellePhase(libellePhase);

		return phaseMapper.convertToPhaseDTO(servPhase.save(pNew));
	}
}
