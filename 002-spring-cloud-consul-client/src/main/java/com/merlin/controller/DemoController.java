package com.merlin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	@RequestMapping("/hello")
	public String hello() {
		String services = "Services:"+discoveryClient.getServices();
		return services;
	}
}
