package com.vifia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class PersonalActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_personal);
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
    }
}