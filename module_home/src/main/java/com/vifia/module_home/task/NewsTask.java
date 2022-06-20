package com.vifia.module_home.task;

import android.os.AsyncTask;

import com.vifia.module_home.bean.News;
import com.vifia.module_home.utils.JSONUtils;
import com.vifia.module_home.utils.NetUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NewsTask extends AsyncTask<String,Void,ArrayList<News>> {
    private NewsCallBack newsCallBack;

    public NewsTask(NewsCallBack newsCallBack) {
        this.newsCallBack = newsCallBack;
    }

    @Override
    protected ArrayList<News> doInBackground(String... strings) {
        //************************访问网络获取数据，得到列表项的数据*****************
        ArrayList<News> result = null;  //创建arraylist ,接收数据
        String params = "{ \"type\":\"" + strings[1] + "\", \"index\":" + strings[2] + ",\"size\": 10 }";
        String url = strings[0];
        String r = NetUtils.post(url, params);
        result = JSONUtils.parseJson(r);
        return result;
    }

    @Override
    protected void onPostExecute(ArrayList<News> result) {
        //在主线程中执行
        if (newsCallBack != null)
            newsCallBack.getResults(result);
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
    public interface NewsCallBack {
        void getResults(ArrayList<News> result);
    }
}
