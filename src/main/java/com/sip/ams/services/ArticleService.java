package com.sip.ams.services;

import com.sip.ams.entities.Article;
import com.sip.ams.entities.Provider;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    public List<Article> getAllArticles();
    public Article saveArticle(Article article);
    public Article updateArticle(Article article);
    public Optional<Article> getArticleById(int id);
    public void deleteArticle(int id);

}
