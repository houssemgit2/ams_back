package com.sip.ams.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Operation(summary = "Récupération de tous les providers")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Succès de get All"),
            @ApiResponse(responseCode = "404", description = "Provider non trouvé"),

    })
    public ResponseEntity<List<Provider>> getAllProviders() {
        return new ResponseEntity<>((List<Provider>) providerRepository.findAll(),HttpStatus.CREATED);
    }

    @PostMapping("/")
    @Operation(summary = "Créer un provider")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Succès de addProvider"),

    })
    public ResponseEntity<Provider> addProvider(@RequestBody Provider p) {
        return new ResponseEntity<Provider>(providerRepository.save(p), HttpStatus.CREATED);
    }

}
