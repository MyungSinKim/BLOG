package com.elkaly.blog.model;

import java.util.List;

public class ArticleList {

    private List<Article> rows;

    public List<Article> getRows() {
        return rows;
    }

    public void setRows(List<Article> rows) {
        this.rows = rows;
    }



    //Constructor
    public ArticleList(List<Article> rows){
        this.rows = rows;
    }
}
