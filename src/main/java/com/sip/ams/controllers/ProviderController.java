package com.sip.ams.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@RestController
@RequestMapping("providers")
public class ProviderController {

	@Autowired
	ProviderRepository providerRepository;

	@GetMapping("/")
	public List<Provider> getAllProviders() {
		return (List<Provider>) providerRepository.findAll();
	}

	@PostMapping("/")
	public Provider addProvider(@RequestBody Provider p) {
		return providerRepository.save(p);
	}

}
