package com.sip.ams.controllers;

import com.sip.ams.dto.ArticleDTO;
import com.sip.ams.entities.Article;
import com.sip.ams.entities.Provider;
import com.sip.ams.services.ArticleService;
import com.sip.ams.services.ProviderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("articles")

public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private ProviderService providerService;

    @GetMapping("/")
    @Operation(summary = "Récupération de tous les articles")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Succès de get All"), @ApiResponse(responseCode = "404", description = "Article non trouvé"),
    })
    public ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @PostMapping("/{idProvider}")
    @Operation(summary = "Créer un article")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Succès de addArticle"),

    })
    public ResponseEntity<Article> addArticle(@RequestBody Article a, @PathVariable("idProvider") int idProvider) {
        Optional<Provider> optProvider = providerService.getProviderById(idProvider);
        if (optProvider.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Provider provider = optProvider.get();
            a.setProvider(provider);
            return new ResponseEntity<>(articleService.saveArticle(a), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Supprimer un article")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si article est supprimé"),
            @ApiResponse(responseCode = "404", description = "Si provider introuvable")
    })
    public ResponseEntity<Article> deleteArticle(@PathVariable int id) {
        Optional<Article> opt = articleService.getArticleById(id);
        if (opt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            articleService.deleteArticle(id);
            return ResponseEntity.noContent().build();
        }
    }

    @PutMapping("/")
    @Operation(summary = "Mettre à jour un article")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Si article est mis à jour"),
            @ApiResponse(responseCode = "404", description = "Si provider introuvable")
    })
    public ResponseEntity<Article> updateProvider(@RequestBody ArticleDTO a) {

        return new ResponseEntity<>(articleService.updateArticle(a), HttpStatus.CREATED);
    }

}
