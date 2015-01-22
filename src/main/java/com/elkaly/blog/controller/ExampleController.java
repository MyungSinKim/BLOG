package com.elkaly.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jeahyukkim on 15. 1. 22..
 */
@Controller
public class ExampleController {

    //DELETE
    @RequestMapping(value = "/jqGrid")
    public String jqGridSample(ModelMap model) {


        return "example/jqGrid";
    }

}
