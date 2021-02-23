package com.mostainahmed.discoverkhulna.website;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.agrawalsuneet.squareloaderspack.loaders.SquareGridLoader;
import com.mostainahmed.discoverkhulna.R;

public class WebActivity extends AppCompatActivity {

    private WebView mWebView;
    ImageView backButton;
    private SquareGridLoader squareGridLoader;
    private TextView textView, textTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String URL = getIntent().getStringExtra("url");
        String urlTitle = getIntent().getStringExtra("urlname");

        squareGridLoader = findViewById(R.id.progressBar);
        mWebView = findViewById(R.id.webView);
        squareGridLoader.setVisibility(View.VISIBLE);
        textView = findViewById(R.id.problemText);
        backButton = findViewById(R.id.img_back);
        textTitle = findViewById(R.id.txt_title);

        textTitle.setText(urlTitle);

        if(isNetworkConnected()){
            textView.setVisibility(View.GONE);
            mWebView.loadUrl(URL);
            WebSettings webSettings = mWebView.getSettings();
            webSettings.setAppCacheMaxSize( 5 * 1024 * 1024 ); // 5MB
            webSettings.setAppCachePath( this.getCacheDir().getAbsolutePath() );
            webSettings.setAllowFileAccess( true );
            webSettings.setAppCacheEnabled( true );
            webSettings.setCacheMode( WebSettings.LOAD_DEFAULT );
            webSettings.setJavaScriptEnabled(true);
            mWebView.getSettings().setCacheMode( WebSettings.LOAD_CACHE_ELSE_NETWORK );
        }else
        {
            textView.setVisibility(View.VISIBLE);
            squareGridLoader.setVisibility(View.GONE);
        }

        mWebView.setWebViewClient(new myWebClient());


        mWebView.canGoBack();
        mWebView.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_BACK
                        && event.getAction() == MotionEvent.ACTION_UP
                        && mWebView.canGoBack()) {
                    mWebView.goBack();
                    return true;
                }
                return false;

            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }
    public class myWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);

        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            //squareGridLoader.setVisibility(View.VISIBLE);
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            squareGridLoader.setVisibility(View.GONE);
            super.onPageFinished(view, url);
        }

    }
}
