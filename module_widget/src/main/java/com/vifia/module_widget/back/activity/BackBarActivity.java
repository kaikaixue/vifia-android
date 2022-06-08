package com.vifia.module_widget.back.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.vifia.module_widget.R;
import com.vifia.module_widget.databinding.ActivityBackBarBinding;

public class BackBarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_bar);

        ActivityBackBarBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_back_bar);
        binding.setTitle("sdaf");
    }
}