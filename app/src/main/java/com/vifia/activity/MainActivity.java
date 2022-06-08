package com.vifia.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.vifia.R;
import com.vifia.module_base.constant.RouterActivityPath;
import com.vifia.module_home.home.HomeFg;
import com.vifia.module_mine.mine.MineFg;

@Route(path = RouterActivityPath.Main.PAGER_MAIN)
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
        // 初始化
        selectTab(0);
    }

    private LinearLayout home;
    private LinearLayout mine;

    private Fragment homeFg;
    private Fragment mineFg;

    public void initEvent() {
        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTab(0);
            }
        });

        mine = findViewById(R.id.mine);
        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTab(1);
            }
        });
    }

    private void selectTab(int i) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragments(transaction);
        switch (i) {
            case 0:
                // 设置第一页的ImageButton为蓝色
//                mImg1.setImageResource(R.drawable.home_blue);
                // 如果第一页对应的Fragment没有实例化，则进行实例化，并显示出来
                if (homeFg == null) {
                    homeFg = new HomeFg();
                    transaction.add(R.id.id_content, homeFg);
                } else {
                    // 已实例化，直接显示
                    transaction.show(homeFg);
                }
                break;
            case 1:
//                mImg2.setImageResource(R.drawable.my_blue);
                if (mineFg == null) {
                    mineFg = new MineFg();
                    transaction.add(R.id.id_content, mineFg);
                } else {
                    transaction.show(mineFg);
                }
                break;
        }
        // 提交事务
        transaction.commit();
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (homeFg != null) {
            transaction.hide(homeFg);
        }
        if (mineFg != null) {
            transaction.hide(mineFg);
        }
    }
}