package com.adaming.proxies;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "microservice-tache")
//@RibbonClient(name = "microservice-tache")
public interface MicroServiceTacheProxies {

}
