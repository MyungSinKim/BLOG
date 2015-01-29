package com.elkaly.blog.service;

import com.elkaly.blog.model.ArticleCtg;
import com.elkaly.blog.repository.ArticleCtgRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleCtgService {

    @Autowired
    ArticleCtgRepository articleCtgRepository;

    public List<ArticleCtg> getArticleCtg(ArticleCtg articleCtg){
        return articleCtgRepository.getArticleCtg(articleCtg)   ;
    }
}
