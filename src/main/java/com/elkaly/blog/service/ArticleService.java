package com.elkaly.blog.service;

import com.elkaly.blog.model.Article;
import com.elkaly.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    @Autowired ArticleRepository articleRepository;

    public void postArticle(Article article){
        articleRepository.postArticle(article);
    }
}
