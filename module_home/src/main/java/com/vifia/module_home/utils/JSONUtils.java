package com.vifia.module_home.utils;

import com.vifia.module_home.bean.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JSONUtils {
    public static ArrayList<News> parseJson(String jsonData) {
        ArrayList<News> result = new ArrayList<>();
        JSONObject jo = null;
        News news;
        try {
            jo = new JSONObject(jsonData);
            if (jo.getString("code").equals("0")) {
                JSONObject jo1 = jo.getJSONObject("data");
                JSONArray ja = jo1.getJSONArray("list");
                for (int i = 0; i < ja.length(); i++) {
                    news = new News();
                    JSONObject obj = ja.getJSONObject(i);
                    news.setPkId(obj.getInt("newsId"));
                    news.setSource(obj.getString("source"));
                    news.setTitle(obj.getString("title"));
                    news.setDate(obj.getString("createTime"));
                    result.add(news);
                }
            }
            return  result;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
