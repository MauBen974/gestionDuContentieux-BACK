package com.adaming.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.dto.TribunalDTO;
import com.adaming.entities.Tribunal;
import com.adaming.mapper.ITribunalMapper;
import com.adaming.services.TribunalService;

@RestController
@CrossOrigin
public class TribunalController {

	@Autowired
	private TribunalService tribunalService;
	@Autowired
	private ITribunalMapper tribunalMapper;

	@GetMapping("/tribunal")
	public List<TribunalDTO> findAll() {
		return tribunalService.findAll().stream().map(t -> tribunalMapper.convertToTribunalDTO(t))
				.collect(Collectors.toList());
	}

	@GetMapping("/tribunalNotArchive")
	public List<TribunalDTO> findAllArchiveFalse() {
		return tribunalService.findAllTribunalArchiveFalse().stream().map(t -> tribunalMapper.convertToTribunalDTO(t))
				.collect(Collectors.toList());
	}

	@GetMapping("/tribunalArchive")
	public List<TribunalDTO> findAllArchiveTrue() {
		return tribunalService.findAllTribunalArchiveTrue().stream().map(t -> tribunalMapper.convertToTribunalDTO(t))
				.collect(Collectors.toList());
	}

	@GetMapping("/tribunal/{id}")
	public Optional<TribunalDTO> findOne(@PathVariable(name = "id") Long id) {
		return tribunalMapper.convertToOptionalTribunalDTO(tribunalService.findById(id));
	}

	@PostMapping("/tribunal")
	public TribunalDTO saveOrUpdate(@RequestBody Tribunal tribunal) {
		return tribunalMapper.convertToTribunalDTO(tribunalService.save(tribunal));
	}

	@DeleteMapping("/tribunal/{id}")
	public void delete(@PathVariable(name = "id") Long id) {
		tribunalService.delete(id);
	}

	@PostMapping("tribunal/{id}")
	public TribunalDTO setArvhiveTrue(@PathVariable(name = "id") Long id) {
		return tribunalMapper.convertToTribunalDTO(tribunalService.setArchiveTrue(id));
	}

}
