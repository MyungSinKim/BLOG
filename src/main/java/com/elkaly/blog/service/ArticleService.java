package com.elkaly.blog.service;

import com.elkaly.blog.model.Article;
import com.elkaly.blog.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;


    public void postArticle(Article article){
        System.out.println("CALL article service");

        articleRepository.postArticle(article);

    }



}
