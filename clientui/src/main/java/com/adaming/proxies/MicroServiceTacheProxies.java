package com.adaming.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.adaming.beans.TacheBean;

@FeignClient(name = "microservice-tache")
//@RibbonClient(name = "microservice-tache")
public interface MicroServiceTacheProxies {
	
	@GetMapping(value = "/taches")
	public List<TacheBean> getAll();

	@GetMapping(value = "/taches/{tId}")
	public TacheBean findOne(@PathVariable(value = "tId") Long id);

	@PostMapping(value = "/taches")
	public TacheBean save(@RequestBody TacheBean tIn);

	@DeleteMapping(value = "taches/{tId}")
	public void delete(@PathVariable(value = "tId") Long id);

	@PutMapping(value = "taches/{pId}")
	public TacheBean update(@PathVariable(value = "tId") Long id, @RequestBody TacheBean tIn);

	@GetMapping(value = "taches/{libellePhase}")
	public List<TacheBean> findBylibellePhase(@PathVariable(value = "libellePhase") String libellePhase);

	@GetMapping(value = "taches/{statusAudience}")
	public List<TacheBean> findByStatusAudience(@PathVariable(value = "statusAudience") Boolean statusAudience);

}
