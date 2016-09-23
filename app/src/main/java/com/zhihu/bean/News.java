package com.zhihu.bean;

import java.io.Serializable;

/**
 * Created by 月海 on 2016/7/4.
 */
public class News implements Serializable{
    private long id;
    private String title = "这是新闻标题";
    private String body = "新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容新闻内容";
    private String author ="作者啦";
    private String pubData = "2016-07-04";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubData() {
        return pubData;
    }

    public void setPubData(String pubData) {
        this.pubData = pubData;
    }
}
