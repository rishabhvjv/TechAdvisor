package com.techadvisor.techadvisor;

import android.annotation.TargetApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class BlogActivity extends AppCompatActivity {

    public WebView mWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_blog);

        mWebview = new WebView(this);
        mWebview.getSettings().setJavaScriptEnabled(true);


//        mWebview.setWebViewClient(new WebViewController());
        mWebview.setWebViewClient(new WebViewClient() {
            @SuppressWarnings("deprecation")
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

            }
            @TargetApi(android.os.Build.VERSION_CODES.M)
            @Override
            public void onReceivedError(WebView view, WebResourceRequest req, WebResourceError rerr) {

            }
        });

        mWebview .loadUrl("https://phoneradar.com/");
        setContentView(mWebview );
//        mWebview.loadUrl("http://www.google.com");



    }
//    public class WebViewController extends WebViewClient {
//
//        @Override
//        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl("http://www.google.com");
//            return true;
//        }
//    }

}
