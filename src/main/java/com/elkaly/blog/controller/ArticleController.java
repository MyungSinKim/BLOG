package com.elkaly.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jeahyukkim on 15. 1. 14..
 */
@Controller
public class ArticleController {

    //POST
    @RequestMapping(method = RequestMethod.POST, value = "/article")
    public String postAtricle(ModelMap model) {
        model.addAttribute("message", "POST Method Call");
        return "hello";
    }

    //GET
    @RequestMapping(method = RequestMethod.GET, value = "/articles/{articleNo}")
    public String getAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        model.addAttribute("message", "GET Method Call");
        return "hello";
    }

    //PUT
    @RequestMapping(method = RequestMethod.PUT, value = "/articles/{articleNo}")
    public String putAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        model.addAttribute("message", "PUT Method Call");
        return "hello";
    }

    //DELETE
    @RequestMapping(method = RequestMethod.DELETE, value = "/articles/{articleNo}")
    public String deleteAtricle(ModelMap model, @PathVariable("articleNo") Integer articleNo) {
        model.addAttribute("message", "DELETE Method Call");
        return "hello";
    }

}
