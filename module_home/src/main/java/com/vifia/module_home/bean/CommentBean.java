package com.vifia.module_home.bean;

import java.util.List;

/**
 * Created by moos on 2018/4/20.
 */

public class CommentBean {
    private int code;
    private String msg;
    private Data data;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public class Data {

        private int total;
        private List<CommentDetailBean> list;

        public void setTotal(int total) {
            this.total = total;
        }

        public int getTotal() {
            return total;
        }

        public void setList(List<CommentDetailBean> list) {
            this.list = list;
        }

        public List<CommentDetailBean> getList() {
            return list;
        }

    }

}
