package com.elkaly.blog.repository;

import com.elkaly.blog.model.Article;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ArticleRepository {

    @Autowired
    SqlSession sqlSession;

    public void postArticle(Article article){
        sqlSession.insert("Article.insertArticle", article);
    }

    public void getArticle(Article article){

    }
}
