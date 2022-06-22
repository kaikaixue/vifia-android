package com.vifia.module_home.task;

import android.content.Intent;
import android.os.AsyncTask;

import com.vifia.module_home.bean.News;
import com.vifia.module_home.bean.NewsDetail;
import com.vifia.module_home.utils.JSONUtils;
import com.vifia.module_home.utils.NetUtils;

import java.util.ArrayList;

public class NewsDetailTask extends AsyncTask<String,Void, NewsDetail> {
    private NewsDetailCallBack newsDetailCallBack;

    public NewsDetailTask(NewsDetailCallBack newsDetailCallBack) {
        this.newsDetailCallBack = newsDetailCallBack;
    }

    @Override
    protected NewsDetail doInBackground(String... strings) {
        //************************访问网络获取数据，得到列表项的数据*****************
        NewsDetail result = null;  //创建arraylist ,接收数据
        String params = "{ \"newsId\":" + strings[1] + "}";
        String url = strings[0];
        String r = NetUtils.post(url, params);
        result = JSONUtils.parseNewsDetail(r);
        return result;
    }

    @Override
    protected void onPostExecute(NewsDetail result) {
        //在主线程中执行
        if (newsDetailCallBack != null)
            newsDetailCallBack.getResults(result);
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
    public interface NewsDetailCallBack {
        void getResults(NewsDetail result);
    }
}

