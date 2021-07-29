package com.my.blog.website.model.Bo;

public class ArticleBo {
    private int cid;
    private String title;
    private String username;
    private int hits;
    private int created;
    private String date;

    public ArticleBo(int cid, String title, String username, int hits, int created, String date) {
        this.cid = cid;
        this.title = title;
        this.username = username;
        this.hits = hits;
        this.created = created;
        this.date = date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public ArticleBo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ArticleBo{" +
                "cid=" + cid +
                ", title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", hits=" + hits +
                ", created=" + created +
                ", date='" + date + '\'' +
                '}';
    }
}
