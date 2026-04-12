package com.sip.ams.controllers;

import java.util.List;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ProviderRepository;

@RestController
@RequestMapping("providers")
public class ProviderController {

    @Autowired
    ProviderRepository providerRepository;

    @GetMapping("/")
    @Operation(summary = "Récupération de tous les providers")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Succès de get All"), @ApiResponse(responseCode = "404", description = "Provider non trouvé"),

    })
    public ResponseEntity<List<Provider>> getAllProviders() {
        return new ResponseEntity<>((List<Provider>) providerRepository.findAll(), HttpStatus.CREATED);
    }

    @PostMapping("/")
    @Operation(summary = "Créer un provider")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Succès de addProvider"),

    })
    public ResponseEntity<Provider> addProvider(@RequestBody Provider p) {
        return new ResponseEntity<Provider>(providerRepository.save(p), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Recherche d'un provider par id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si provider est trouvé"),
            @ApiResponse(responseCode = "404", description = "Si provider introuvable")
    })
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        Optional<Provider> opt = providerRepository.findById(id);
        if (opt.isEmpty()) {
            return  ResponseEntity.notFound().build();
        } else {
            return new ResponseEntity<>(opt.get(), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un provider")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si provider est supprimé"),
            @ApiResponse(responseCode = "404", description = "Si provider introuvable")
    })
    public ResponseEntity<Provider> deleteProvider(@PathVariable Long id) {
        Optional<Provider> opt = providerRepository.findById(id);
        if (opt.isEmpty()) {
            return  ResponseEntity.notFound().build();
        } else {
            providerRepository.deleteById(id);
            return  ResponseEntity.noContent().build();
        }

    }

    @PutMapping("/")
    @Operation(summary = "Mettre à jour un provider")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si provider est mis à jour"),
            @ApiResponse(responseCode = "404", description = "Si provider introuvable")
    })
    public ResponseEntity<Provider> updateProvider(@RequestBody Provider p){
        Optional<Provider> opt = providerRepository.findById(p.getId());
        if (opt.isEmpty()) {
            return  ResponseEntity.notFound().build();
        } else {
            Provider newProvider= opt.get();
            newProvider.setName(p.getName());
            newProvider.setAddress(p.getAddress());
            newProvider.setEmail(p.getEmail());
            return new ResponseEntity<Provider>(providerRepository.save(newProvider), HttpStatus.OK);
        }
    }

}
