package com.hitherejoe.tabby.ui.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.hitherejoe.tabby.R;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import timber.log.Timber;

public class WebViewActivity extends BaseActivity {

    @Bind(R.id.web_view)
    WebView mWebView;

    public static final String EXTRA_URL =
            "com.hitherejoe.tabby.ui.activity.WebViewActivity.EXTRA_URL";
    private long mTime;
    private boolean isLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        String url = getIntent().getStringExtra(EXTRA_URL);
        WebViewClient client = new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Timber.d("loading URL: %s", url);
                if (!isLoading) {
                    mTime = System.nanoTime();
                    Timber.d("start %d", mTime);
                    isLoading = true;
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Timber.d("finished %d", mTime);
                mTime = System.nanoTime() - mTime;
                Timber.d("Time to load %d ns", mTime);
                isLoading = false;
                showTime();
            }
        };
        mWebView.setWebViewClient(client);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
        setupActionBar(url);
    }

    private void showTime() {
        Toast.makeText(this,
                getString(R.string.toast_load_time, TimeUnit.NANOSECONDS.toMillis(mTime) / 1000d),
                Toast.LENGTH_LONG).show();
    }

    private void setupActionBar(String url) {
        setTitle(url);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }
}