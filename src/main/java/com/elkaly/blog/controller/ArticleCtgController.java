package com.elkaly.blog.controller;

import com.elkaly.blog.model.ArticleCtg;
import com.elkaly.blog.service.ArticleCtgService;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleCtgController {

    private static final Logger logger = Logger.getLogger(ArticleController.class.getName());

    @Autowired
    ArticleCtgService articleCtgService;

    @RequestMapping(method = RequestMethod.GET, value = "/articleCtg")
    public String getAtricleCtg() {
        return "/category/articleCtg";
    }

    //GET
    @RequestMapping(method = RequestMethod.GET, value = "/articleCtgData", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String getAtricleCtgData() {
        logger.debug("CALL getArticleCtg Method: ");
        ArticleCtg articleCtg = new ArticleCtg();
        //articleCtg.setUseYn("Y");
        List<ArticleCtg> articleCtgList = articleCtgService .getArticleCtg(articleCtg);
        String json = new Gson().toJson(articleCtgList );
        return json;
    }
}
