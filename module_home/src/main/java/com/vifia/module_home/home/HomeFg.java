package com.vifia.module_home.home;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vifia.module_base.constant.RouterActivityPath;
import com.vifia.module_home.R;
import com.vifia.module_home.content.ContentFg;

import java.util.ArrayList;

@Route(path = RouterActivityPath.Home.PAGER_HOME)
public class HomeFg extends Fragment implements View.OnClickListener {

    private HorizontalScrollView hs;
    private LinearLayout liner;
    private View contextView;// 总视图
    private String[] titles;
    private ArrayList<TextView> titlesView;
    private ViewPager viewpager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contextView = inflater.inflate(R.layout.fragment_home_fg, container, false);
        hs = contextView.findViewById(R.id.hs);
        liner = contextView.findViewById(R.id.liner);
        viewpager = contextView.findViewById(R.id.orderListContent);
        titles = new String[]{"体育","娱乐","房产","教育","教育","教育","体育","娱乐","房产","教育","教育","教育"};
        return contextView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initTitles();
        viewpager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return ContentFg.getInstance(titles[position]);
            }

            @Override
            public int getCount() {
                return titles.length;
            }
        });
        setOnClickListener();
    }

    private void initTitles() {
        // 装标题控件的集合
        titlesView = new ArrayList<>();
        for (int i = 0; i < titles.length; i++) {
            TextView textView = new TextView(getActivity());
            textView.setTextSize(35);
            if (i == 0) {
                textView.setTextColor(Color.RED);
            }
            textView.setText(titles[i]);
            textView.setId(i);
            textView.setOnClickListener(this);

            //LinearLayout中的孩子的定位参数
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
            layoutParams.setMargins(10,10,10,10);//设置左上右下四个margin值;
            //layoutParams是让linearLayout知道如何摆放自己孩子的位置的;
            liner.addView(textView,layoutParams);
            titlesView.add(textView);
        }
    }

    private void setOnClickListener() {
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //当页面在滑动的时候会调用此方法，在滑动被停止之前，此方法回一直被调用。
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            // 此方法是页面跳转完后被调用
            @Override
            public void onPageSelected(int position) {
                // 标题变色,用循环改变标题颜色,通过判断来决定谁红谁灰;
                // 举例:娱乐的下标是position是1
                for (int i = 0; i < titles.length; i++) {
                    if(i == position){
                        titlesView.get(i).setTextColor(Color.RED);
                    }else {
                        titlesView.get(i).setTextColor(Color.GRAY);
                    }

                }
                // 标题滑动功能
                int width = titlesView.get(position).getWidth();
                int totalWidth = (width +20)*position;
                hs.scrollTo(totalWidth,0);
            }

            // 此方法是在状态改变的时候调用。
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        viewpager.setCurrentItem(id);
    }
}