package com.adaming.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.adaming.beans.TribunalBean;

@FeignClient(name = "microservice-tribunal")
//@RibbonClient(name = "microservice-tribunal")
public interface MicroServiceTribunalProxies {
	
	 @GetMapping("/tribunal")
	 List<TribunalBean> findAll();
 
}
