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

@FeignClient(name = "microservice-tache")
//@RibbonClient(name = "microservice-tache")
public interface MicroServicePhaseProxies {
	
	@GetMapping(value = "/phases")
	List<PhaseBean> getAll();

	@GetMapping(value = "/phases/{pId}")
	PhaseBean findOne(@PathVariable(value = "pId") Long id);

	@PostMapping(value = "/phases")
	PhaseBean save(@RequestBody PhaseBean pIn);

	@DeleteMapping(value = "phases/{pId}")
	void delete(@PathVariable(value = "pId") Long id);

	@PutMapping(value = "phases/{pId}")
	public PhaseBean update(@PathVariable(value = "pId") Long id, @RequestBody PhaseBean pIn);

}
