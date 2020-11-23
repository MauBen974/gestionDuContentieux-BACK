package com.adaming.proxies;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.adaming.beans.TribunalBean;

@FeignClient(name = "microservice-tribunal")
@RibbonClient(name = "microservice-tribunal")
public interface MicroServiceTribunalProxies {
	
	 @GetMapping("/tribunal")
	 List<TribunalBean> findAll();
	 
	 @GetMapping("/tribunalNotArchive")
	 List<TribunalBean> findAllArchiveFalse();
	 
	 @GetMapping("/tribunalArchive")
	 List<TribunalBean> findAllArchiveTrue();
	 
	 @GetMapping("/tribunal/{id}")
	 Optional<TribunalBean> findOne(@PathVariable(name = "id") Long id);
	 
	 @PostMapping("/tribunal")
	 TribunalBean saveOrUpdate(@RequestBody TribunalBean tribunal);
	 
	 @DeleteMapping("/tribunal/{id}")
	 void delete(@PathVariable(name = "id") Long id);
	 
	 @PostMapping("tribunal/{id}")
	 TribunalBean setArchiveTrue(@PathVariable(name = "id") Long id);
 
}
