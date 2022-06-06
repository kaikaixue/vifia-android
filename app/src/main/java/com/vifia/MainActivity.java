package com.vifia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    // 声明两个Tab的布局文件
    private LinearLayout mTab1;
    private LinearLayout mTab2;

    // 声明两个Tab的ImageButton
    private ImageButton mImg1;
    private ImageButton mImg2;

    // 声明两个Tab对应的Fragment
    private Fragment mFrag1;
    private Fragment mFrag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initViews(); // 初始化控件
        initEvents(); //初始化事件
        selectTab(0); // 默认选中第一个Tab
    }

    private void initEvents() {
        // 初始化两个Tab事件
        mTab1.setOnClickListener(this);
        mTab2.setOnClickListener(this);
    }

    private void initViews() {
        // 初始化两个Tab布局文件
        mTab1 = (LinearLayout) findViewById(R.id.id_tab1);
        mTab2 = (LinearLayout) findViewById(R.id.id_tab2);

        // 初始化两个ImageButton
        mImg1 = (ImageButton) findViewById(R.id.id_tab_img1);
        mImg2 = (ImageButton) findViewById(R.id.id_tab_img2);
    }

    // 处理Tab的点击事件
    @Override
    public void onClick(View v) {
        resetImgs();    // 先将两个ImageButton置为灰色
        switch (v.getId()) {
            case R.id.id_tab1:
                selectTab(0);
                break;
            case R.id.id_tab2:
                selectTab(1);
                break;
        }
    }

    // 进行选中Tab的处理
    private void selectTab(int i) {
        // 获取FragmentManager对象
        FragmentManager manager = getSupportFragmentManager();
        // 获取FragmentTransaction对象
        FragmentTransaction transaction = manager.beginTransaction();
        // 先隐藏所有的Fragment
        hideFragments(transaction);
        switch (i) {
            case 0:
                // 设置第一页的ImageButton为蓝色
                mImg1.setImageResource(R.drawable.home_blue);
                // 如果第一页对应的Fragment没有实例化，则进行实例化，并显示出来
                if (mFrag1 == null) {
                    mFrag1 = new PageFragmentHome();
                    transaction.add(R.id.id_content, mFrag1);
                } else {
                    // 已实例化，直接显示
                    transaction.show(mFrag1);
                }
                break;
            case 1:
                mImg2.setImageResource(R.drawable.my_blue);
                if (mFrag2 == null) {
                    mFrag2 = new PageFragmentMy();
                    transaction.add(R.id.id_content, mFrag2);
                } else {
                    transaction.show(mFrag2);
                }
                break;
        }
        // 提交事务
        transaction.commit();
    }

    // 将两个Fragment隐藏
    private void hideFragments(FragmentTransaction transaction) {
        if (mFrag1 != null) {
            transaction.hide(mFrag1);
        }
        if (mFrag2 != null) {
            transaction.hide(mFrag2);
        }
    }

    // 将两个ImageButton置为黑色
    private void resetImgs() {
        mImg1.setImageResource(R.drawable.home_black);
        mImg2.setImageResource(R.drawable.my_black);
    }
}