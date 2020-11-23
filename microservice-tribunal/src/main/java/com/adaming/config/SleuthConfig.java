package com.adaming.config;

import org.springframework.context.annotation.Configuration;

import brave.sampler.Sampler;

@Configuration
public class SleuthConfig {

	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
}
