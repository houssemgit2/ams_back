package com.sip.ams.services;

import com.sip.ams.entities.Article;
import com.sip.ams.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> getAllArticles() {
        return (List<Article>) articleRepository.findAll();
    }

    @Override
    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article updateArticle(Article article) {
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
}