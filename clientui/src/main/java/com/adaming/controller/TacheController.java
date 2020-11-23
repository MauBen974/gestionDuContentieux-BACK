package com.adaming.controller;

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

import com.adaming.beans.TacheBean;

import com.adaming.proxies.MicroServiceTacheProxies;

@RestController
@CrossOrigin
public class TacheController {

	@Autowired
	private MicroServiceTacheProxies microserviceTacheProxies;

	@GetMapping(value = "/taches")
	public List<TacheBean> getAll() {
		return microserviceTacheProxies.getAllTache();
	}

	@GetMapping(value = "/tachesById/{tId}")
	public TacheBean findOne(@PathVariable(value = "tId") Long id) {
		return microserviceTacheProxies.findOneTache(id);
	}

	@PostMapping(value = "/taches")
	public TacheBean save(@RequestBody TacheBean tIn) {
		return microserviceTacheProxies.saveTache(tIn);
	}

	@DeleteMapping(value = "taches/{tId}")
	public void delete(@PathVariable(value = "tId") Long id) {
		microserviceTacheProxies.deleteTache(id);
	}

	@PutMapping(value = "taches/{tId}")
	public TacheBean update(@PathVariable(value = "tId") Long id, @RequestBody TacheBean tIn) {
		return microserviceTacheProxies.updateTache(id, tIn);
	}

	@GetMapping(value = "tachesLibelle/{libellePhase}")
	public List<TacheBean> findBylibellePhase(@PathVariable(value = "libellePhase") String libellePhase) {
		return microserviceTacheProxies.findTacheBylibellePhase(libellePhase);
	}

	@GetMapping(value = "tachesAudience/{statusAudience}")
	public List<TacheBean> findByStatusAudience(@PathVariable(value = "statusAudience") Boolean statusAudience) {
		return microserviceTacheProxies.findTacheByStatusAudience(statusAudience);
	}
}