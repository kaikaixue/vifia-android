package com.vifia.module_home.content;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.vifia.module_home.R;
import com.vifia.module_home.adapter.NewsAdapter;
import com.vifia.module_home.bean.News;
import com.vifia.module_home.bean.NewsDetail;
import com.vifia.module_home.newsDetail.NewsDetailActivity;
import com.vifia.module_home.task.NewsDetailTask;
import com.vifia.module_home.task.NewsTask;

import java.util.ArrayList;

public class ContentFg extends Fragment {
    private NewsDetail newsDetail = new NewsDetail();
    private ListView listView;
    private View footView;
    private ArrayList<News> data = new ArrayList<>();
    private NewsAdapter adapter;
    private boolean isLoading = true,isDown = false;

    private static String URL = "http://192.168.59.1:8081/news/findByType";
    private String title;

    public static Fragment getInstance(String title) {
        ContentFg contentFg = new ContentFg();
        contentFg.title = title;
        return contentFg;
    }

    public ContentFg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_content, container, false);
        footView = View.inflate(getContext(), R.layout.footer_layout, null);
        listView = (ListView) view.findViewById(R.id.listview);
        listView.addFooterView(footView,null,true);
        loadData(URL, title, 1);
        adapter = new NewsAdapter(getActivity(), R.layout.activity_news_item,data);
        listView.setAdapter(adapter);

        // 添加列表滚动事件
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int scrollState) {
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    loadData(URL, title, absListView.getCount());
                    adapter.notifyDataSetChanged();
                }
//                if (isDown == true && scrollState==SCROLL_STATE_IDLE) {
//                    loadData(URL, title);
//                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
            }
        });

        // 列表添加点击事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                loadDetail("http://192.168.59.1:8081/news/find", data.get(i).getPkId());

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    private void loadDetail(String URL, int newsId) {
        new NewsDetailTask(new NewsDetailTask.NewsDetailCallBack() {
            @Override
            public void getResults(NewsDetail result) {
                newsDetail.setDate(result.getDate());
                newsDetail.setTitle(result.getTitle());
                newsDetail.setSource(result.getSource());
                newsDetail.setType(result.getType());
                newsDetail.setContent(result.getContent());
                Intent intent = new Intent(getActivity(), NewsDetailActivity.class);
                intent.putExtra("title", newsDetail.getTitle());
                intent.putExtra("content", newsDetail.getContent());
                intent.putExtra("type", newsDetail.getType());
                intent.putExtra("source", newsDetail.getSource());
                intent.putExtra("date", newsDetail.getDate());
                intent.putExtra("newsId", newsId);
                startActivity(intent);
            }
        }).execute(URL, String.valueOf(newsId));
    }

    private void loadData(String URL, String title, int count) {
        if (isLoading) {
            isLoading = false;
            new NewsTask(new NewsTask.NewsCallBack() {
                @Override
                public void getResults(ArrayList<News> result) {
                    data.addAll(result);
                    adapter.notifyDataSetChanged();
                }
            }).execute(URL, title, String.valueOf(count));
            isLoading = true;
        }
    }
}
