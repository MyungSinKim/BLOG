package com.elkaly.blog.repository;

import com.elkaly.blog.model.Article;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ArticleRepository {

    @Autowired
    SqlSession sqlSession;

    public void postArticle(Article article){
        sqlSession.insert("Article.insertArticle", article);
    }

    public Article getArticle(Integer articleNo){
        return sqlSession.selectOne("Article.selectArticle", articleNo);
    }


    public void putArticle(Article article){
        sqlSession.update("Article.updateArticle", article);
    }

    public void deleteArticle(Integer articleNo){
        sqlSession.delete("Article.deleteArticle", articleNo);
    }

    public List<Article> getArticles(){
        return sqlSession.selectList("Article.selectArticles");
    }

}
