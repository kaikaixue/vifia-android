package com.vifia.module_mine.personal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.vifia.module_base.constant.RouterActivityPath;
import com.vifia.module_mine.R;

@Route(path = RouterActivityPath.Mine.PAGER_PERSONAL)
public class PersonalAc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
    }
}