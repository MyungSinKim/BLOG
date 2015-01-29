package com.elkaly.blog.repository;

import com.elkaly.blog.model.ArticleCtg;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleCtgRepository {

    @Autowired
    SqlSession sqlSession;

    public List<ArticleCtg> getArticleCtg(ArticleCtg articlectg){
        return sqlSession.selectList("ArticleCtg.selectArticleCtg", articlectg);
    }

}
