package com.adaming.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.adaming.beans.PhaseBean;
import com.adaming.beans.TacheBean;

@FeignClient(name = "microservice-tache")
//@RibbonClient(name = "microservice-tache")
public interface MicroServiceTacheProxies {
	
	@GetMapping(value = "/phases")
	List<PhaseBean> getAllPhases();

	@GetMapping(value = "/phases/{pId}")
	PhaseBean findOnePhase(@PathVariable(value = "pId") Long id);

	@PostMapping(value = "/phases")
	PhaseBean savePhase(@RequestBody PhaseBean pIn);

	@DeleteMapping(value = "phases/{pId}")
	void deletePhase(@PathVariable(value = "pId") Long id);

	@PutMapping(value = "phases/{pId}")
	public PhaseBean updatePhase(@PathVariable(value = "pId") Long id, @RequestBody PhaseBean pIn);
	
	@GetMapping(value = "/taches")
	public List<TacheBean> getAllTache();

	@GetMapping(value = "/taches/{tId}")
	public TacheBean findOneTache(@PathVariable(value = "tId") Long id);

	@PostMapping(value = "/taches")
	public TacheBean saveTache(@RequestBody TacheBean tIn);

	@DeleteMapping(value = "taches/{tId}")
	public void deleteTache(@PathVariable(value = "tId") Long id);

	@PutMapping(value = "taches/{tId}")
	public TacheBean updateTache(@PathVariable(value = "tId") Long id, @RequestBody TacheBean tIn);

	@GetMapping(value = "taches/{libellePhase}")
	public List<TacheBean> findTacheBylibellePhase(@PathVariable(value = "libellePhase") String libellePhase);

	@GetMapping(value = "taches/{statusAudience}")
	public List<TacheBean> findTacheByStatusAudience(@PathVariable(value = "statusAudience") Boolean statusAudience);

}
