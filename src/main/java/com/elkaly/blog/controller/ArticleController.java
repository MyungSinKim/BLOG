package com.elkaly.blog.controller;

import com.elkaly.blog.model.Article;
import com.elkaly.blog.model.ArticleList;
import com.elkaly.blog.service.ArticleService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * Created by jeahyukkim on 15. 1. 14..
 */
@Controller
public class ArticleController {

    private static final Logger logger = Logger.getLogger(ArticleController.class.getName());

    @Autowired
    ArticleService articleService;

    //Article CRUD
    //GET
    @RequestMapping(method = RequestMethod.GET, value = "/articles/{articleNo}")
    public String getAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {

        logger.debug("CALL getArticle Method: " + articleNo + "================");

        Article article = articleService.getArticle(articleNo);
        model.addAttribute("article", article);
        return "article/article";
    }

    //GET Article Write PAGE
    @RequestMapping(method = RequestMethod.GET, value = "/article/write")
    public String getArticlePage(ModelMap model) {
        return "article/article";
    }

    //POST Article
    @RequestMapping(method = RequestMethod.POST, value = "/article")
    @ResponseBody
    public String postAtricle(ModelMap model, @RequestBody Article article) {
        articleService.postArticle(article);
        String articleNo = article.getArticleNo().toString();
        return articleNo;
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{articleNo}", consumes="application/json")
    @ResponseBody
    public String putArticle(ModelMap model, @PathVariable("articleNo") Integer articleNo, @RequestBody Article article) {
        articleService.putArticle(article);
        return articleNo.toString();
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{articleNo}")
    @ResponseBody
    public String deleteAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        articleService.deleteArticle(articleNo);
        return "/articles";
    }

    //Article List Page
    //GET Article List Page
    @RequestMapping(method = RequestMethod.GET, value = "/articles")
    public String getArticleListPage(ModelMap model) {
        return "article/articleList";
    }

    //GET Article List Data
    @RequestMapping(method = RequestMethod.GET, value = "/articleListData", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAtricles(ModelMap model, @RequestParam("ctgName") String ctgName ) {

        Article article = new Article();
        if(ctgName.length() == 0){
            article.setCtgName(null);
        }else{
            article.setCtgName(ctgName);
        }

        String json = new Gson().toJson(new ArticleList(1,1,1, articleService.getArticles(article)) );
        return json;
    }

    //POST Article List Data
    @RequestMapping(method = RequestMethod.POST, value = "/articleListDataPOST",
                    consumes="application/json", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String getAtriclesPost(ModelMap model, @RequestBody Article article) {
        //카테고리가 없을 경우도 있기 때문에 null값을 준다. 아니면 공백이 쿼리로 넘어간다..
        if(article.getCtgName().length() == 0){
            article.setCtgName(null);
        }
        String json = new Gson().toJson(new ArticleList(1,1,1, articleService.getArticles(article)) );
        return json;
    }

    //GET Article CTG List Data
    @RequestMapping(method = RequestMethod.GET, value = "/category/{ctgName}")
    public String getAtriclesCtgData(ModelMap model, @PathVariable("ctgName") String ctgName) {
        Article article = new Article();
        article.setCtgName(ctgName);
        model.addAttribute("article", article);
        return "article/articleList";
    }
}
