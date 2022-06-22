package com.vifia.module_home.bean;

import java.util.List;

public class ReplyDetailBean {
    private String nickName;
    private String avatar;
    private int userId;
    private String commentId;
    private String content;
    private String createTime;

    public List<ReplyDetailBean> getList() {
        return list;
    }

    public void setList(List<ReplyDetailBean> list) {
        this.list = list;
    }

    private List<ReplyDetailBean> list;

    public ReplyDetailBean(String nickName, String content) {
        this.nickName = nickName;
        this.content = content;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return nickName;
    }

    public void setAvatar(String userLogo) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    public String getCommentId() {
        return commentId;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }


    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    public String getCreateTime() {
        return createTime;
    }

}
