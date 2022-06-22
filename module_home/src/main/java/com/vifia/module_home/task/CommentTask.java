package com.vifia.module_home.task;

import android.os.AsyncTask;


import android.content.Intent;
import android.os.AsyncTask;

import com.vifia.module_home.bean.News;
import com.vifia.module_home.bean.NewsDetail;
import com.vifia.module_home.utils.JSONUtils;
import com.vifia.module_home.utils.NetUtils;
import com.vifia.module_home.utils.OKHttpTool;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class CommentTask extends AsyncTask<String,Void, String> {
    private CommentCallBack commentCallBack;

    public CommentTask(CommentCallBack commentCallBack) {
        this.commentCallBack = commentCallBack;
    }

    @Override
    protected String doInBackground(String... strings) {
        //************************访问网络获取数据，得到列表项的数据*****************
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("newsId", 3);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String url = strings[0];
        String r = null;
        try {
            r = OKHttpTool.post(url, jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    protected void onPostExecute(String result) {
        //在主线程中执行
        if (commentCallBack != null)
            commentCallBack.getResults(result);
        super.onPostExecute(result);
    }


    @Override
    protected void onPreExecute() {
        //在主线程执行
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        //做进度显示的操作
        super.onProgressUpdate(values);
    }

    //定义接口
    public interface CommentCallBack {
        void getResults(String result);
    }
}


