package com.elkaly.blog.controller;

import com.elkaly.blog.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jeahyukkim on 15. 1. 14..
 */
@Controller
public class ArticleController {

    //Article CRUD

    //POST
    @RequestMapping(method = RequestMethod.POST, value = "/article")
    @ResponseBody
    public Article postAtricle(@RequestBody Article article) {

        return article;
    }

    //GET
    @RequestMapping(method = RequestMethod.GET, value = "/articles/{articleNo}")
    @ResponseBody
    public String getAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        model.addAttribute("message", "GET Method Call");
        return "article/article";
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{articleNo}")
    @ResponseBody
    public String putAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        model.addAttribute("message", "PUT Method Call");
        return "article/article";
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{articleNo}")
    @ResponseBody
    public String deleteAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        model.addAttribute("message", "DELETE Method Call");
        return "article/article";
    }


    //Article List
    //GET
    @RequestMapping(method = RequestMethod.GET, value = "/articles")
    @ResponseBody
    public String getAtricleList(ModelMap model) {
        model.addAttribute("message", "GET Method Call");
        return "article/articleList";
    }

}
