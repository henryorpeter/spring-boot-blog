package com.yjj.blog.po;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: JKing
 * \* Date: 2020/10/14
 * \* Time: 18:29
 */
@Entity(name = "jj_blog")
public class Blog {
    @Id
    @GeneratedValue
    /**主键**/
    private Long id;
    /**标题**/
    private String title;
    /**内容**/
    private String content;
    /**首张图**/
    private String firstPicture;
    /**标记**/
    private String flag;
    /**浏览次数**/
    private String views;
    /**悬赏是否开启。。。**/
    private boolean openAppreciation;
    /**版权**/
    private boolean share;
    /**评论**/
    private boolean comment;
    /**发布**/
    private boolean published;
    /**是否推荐**/
    private boolean recommend;
    /**创建时间**/
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    /**结束时间**/
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**维护端多对一**/
    @ManyToOne
    private Type type;

    /**多对多**/
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    /**多对一**/
    @ManyToOne
    private User user;

    /**一对多**/
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

    public Blog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFirstPicture() {
        return firstPicture;
    }

    public void setFirstPicture(String firstPicture) {
        this.firstPicture = firstPicture;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public boolean isOpenAppreciation() {
        return openAppreciation;
    }

    public void setOpenAppreciation(boolean openAppreciation) {
        this.openAppreciation = openAppreciation;
    }

    public boolean isShare() {
        return share;
    }

    public void setShare(boolean share) {
        this.share = share;
    }

    public boolean isComment() {
        return comment;
    }

    public void setComment(boolean comment) {
        this.comment = comment;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", firstPicture='" + firstPicture + '\'' +
                ", flag='" + flag + '\'' +
                ", views='" + views + '\'' +
                ", openAppreciation=" + openAppreciation +
                ", share=" + share +
                ", comment=" + comment +
                ", published=" + published +
                ", recommend=" + recommend +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}