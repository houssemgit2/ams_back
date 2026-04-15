package com.sip.ams.services;

import com.sip.ams.dto.ArticleDTO;
import com.sip.ams.entities.Article;
import com.sip.ams.entities.Provider;
import com.sip.ams.repositories.ArticleRepository;
import com.sip.ams.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ProviderService providerService;

    @Override
    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Optional<Article> getArticleById(int id) {
        return articleRepository.findById(id);
    }

    @Override
    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }

    @Override
    public Article updateArticle(ArticleDTO articleDTO) {

        Article article = getArticleById(articleDTO.getId())
                .orElseThrow(() -> new RuntimeException("Article introuvable"));

        Provider provider = providerService
                .getProviderById(articleDTO.getIdProvider())
                .orElseThrow(() -> new RuntimeException("Provider introuvable"));

        article.setLibelle(articleDTO.getLibelle());
        article.setPrice(articleDTO.getPrice());
        article.setProvider(provider);

        return saveArticle(article);
    }
}