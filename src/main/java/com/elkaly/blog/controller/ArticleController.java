package com.elkaly.blog.controller;

import com.elkaly.blog.model.Article;
import com.elkaly.blog.service.ArticleService;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeahyukkim on 15. 1. 14..
 */
@Controller
public class ArticleController {

    @Autowired
    ArticleService articleService;




    //Article CRUD
    //POST
    @RequestMapping(method = RequestMethod.POST, value = "/article")
    public String postAtricle(ModelMap model, @RequestBody Article article) {
        articleService.postArticle(article);
        return getAtricle(model, article.getArticleNo()); //getArticle
    }

    //GET
    @RequestMapping(method = RequestMethod.GET, value = "/articles/{articleNo}")
    public String getAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        Article article = articleService.getArticle(articleNo);
        model.addAttribute("article", article);
        return "article/article";
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{articleNo}")
    public String putArticle(ModelMap model, @PathVariable("articleNo") Integer articleNo, @RequestBody Article article) {
        articleService.putArticle(article);
        return getAtricle(model, article.getArticleNo());
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{articleNo}")
    public String deleteAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        articleService.deleteArticle(articleNo);
        return getAtricleList(model);
    }

    //Article List
    //GET
    @RequestMapping(method = RequestMethod.GET, value = "/articles")
    public String getAtricleList(ModelMap model) {
        String json = new Gson().toJson(articleService.getArticles() );
        model.addAttribute("articles", json);
        return "article/articleList";
    }
}
