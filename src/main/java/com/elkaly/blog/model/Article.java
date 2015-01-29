package com.elkaly.blog.model;
import org.apache.ibatis.type.Alias;

@Alias("Article")
public class Article {

    private Integer articleNo;
    private String title;
    private String contents;
    private Integer ctgSeq;
    private String ctgName;

    public Integer getArticleNo() {
        return articleNo;
    }

    public void setArticleNo(Integer articleNo) {
        this.articleNo = articleNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Integer getCtgSeq() {
        return ctgSeq;
    }

    public void setCtgSeq(Integer ctgSeq) {
        this.ctgSeq = ctgSeq;
    }

    public String getCtgName() {
        return ctgName;
    }

    public void setCtgName(String ctgName) {
        this.ctgName = ctgName;
    }
}
