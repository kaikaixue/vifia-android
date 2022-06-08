package com.vifia.module_home.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.vifia.module_base.constant.RouterActivityPath;
import com.vifia.module_home.R;
import com.vifia.module_home.education.EducationFg;
import com.vifia.module_home.entertainment.EntertainmentFg;
import com.vifia.module_home.house.HouseFg;
import com.vifia.module_home.sports.SportsFg;

import java.util.ArrayList;

@Route(path = RouterActivityPath.Home.PAGER_HOME)
public class HomeFg extends Fragment {

    private View contextView;// 总视图
    private TabLayout tabLayout;
    private ViewPager viewpager;
    ArrayList fragmentList = new ArrayList<Fragment>();
    String[] temp = {"体育","娱乐","房产","教育","教育","教育"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contextView = inflater.inflate(R.layout.fragment_home_fg, container, false);
        tabLayout = contextView.findViewById(R.id.orderListTab);
        viewpager = contextView.findViewById(R.id.orderListContent);
        return contextView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // fragment中嵌套fragment, Manager需要用(getChildFragmentManager())
        MPagerAdapter mPagerAdapter = new MPagerAdapter(getChildFragmentManager());
        initFragment();
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setAdapter(mPagerAdapter);
    }

    private void initFragment() {
        fragmentList.add(new SportsFg());
        fragmentList.add(new EntertainmentFg());
        fragmentList.add(new HouseFg());
        fragmentList.add(new EducationFg());
        fragmentList.add(new EducationFg());
        fragmentList.add(new EducationFg());
    }


    class MPagerAdapter extends FragmentPagerAdapter {


        public MPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return (Fragment) fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        //返回tablayout的标题文字;
        @Override
        public CharSequence getPageTitle(int position) {
            return temp[position];
        }
    }

}