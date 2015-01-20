package com.elkaly.blog.service;

import com.elkaly.blog.model.Article;
import com.elkaly.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;


    public void postArticle(Article article){
        articleRepository.postArticle(article);
    }

    public Article getArticle(Integer articleNo){
        return articleRepository.getArticle(articleNo);
    }

    public void putArticle(Article article){
        articleRepository.putArticle(article);
    }

    public void deleteArticle(Integer articleNo){
        articleRepository.deleteArticle(articleNo);
    }

    public List<Article> getArticles(){
        return articleRepository.getArticles();
    }

}
