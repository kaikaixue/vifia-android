package com.vifia.module_home.newsDetail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.vifia.module_home.R;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

public class NewsDetailActivity extends Activity {
    private String htmlContents = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        HtmlTextView htmlTextView = findViewById(R.id.html_text);
        final Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        htmlContents = bundle.getCharSequence("contents").toString();
        htmlTextView.setHtml(htmlContents, new HtmlHttpImageGetter(htmlTextView));
    }
}
