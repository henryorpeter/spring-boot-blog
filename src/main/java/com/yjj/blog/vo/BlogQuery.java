package com.yjj.blog.vo;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: JKing
 * \* Date: 2021/2/3
 * \* Time: 23:06
 * \
 */
public class BlogQuery {
    private String title;

    private Long typeId;

    private boolean recommend;

    public BlogQuery() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }
}