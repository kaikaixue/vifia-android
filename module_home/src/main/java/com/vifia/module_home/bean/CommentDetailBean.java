package com.vifia.module_home.bean;

import java.util.List;

public class CommentDetailBean {
    private int commentId;
    private int userId;
    private String nickName;
    private String avatar;
    private String content;
    private String createTime;
    private List<ReplyDetailBean> list;

    public CommentDetailBean(String nickName,  String content, String createDate) {
        this.nickName = nickName;
        this.content = content;
        this.createTime = createDate;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }
    public int getCommentId() {
        return commentId;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return nickName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    public String getAvatar() {
        return avatar;
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

    public void setList(List<ReplyDetailBean> replyList) {
        this.list = replyList;
    }
    public List<ReplyDetailBean> getList() {
        return list;
    }
}