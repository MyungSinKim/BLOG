package com.elkaly.blog.model;

import java.util.List;

public class ArticleList {

    private Integer total;
    private Integer page;
    private Integer records;
    private List<Article> rows;


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRecords() {
        return records;
    }

    public void setRecords(Integer records) {
        this.records = records;
    }

    public List<Article> getRows() {
        return rows;
    }

    public void setRows(List<Article> rows) {
        this.rows = rows;
    }

    //Constructor
    public ArticleList(Integer total, Integer page, Integer records,  List<Article> rows){
        this.total = total;
        this.page = page;
        this.records = records;
        this.rows = rows;
    }
}
