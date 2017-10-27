package com.badr.hourimeche.ensakenitra;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebV extends AppCompatActivity {

    private WebView web;
    private String name;
    private String url;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_web_view);

        Intent intent = this.getIntent();
        name = intent.getStringExtra("name");
        url = intent.getStringExtra("url");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.action_bar_title_layout);
        ((TextView) findViewById(R.id.action_bar_title)).setText(name);

        web = (WebView) findViewById(R.id.webUrl);
        new vaa().execute();
        web.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.endsWith(".pdf")) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                    return true;
                }
                return false;
            }
        });

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Veuillez Attendre s'il vous plaît !!");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();
        progressDialog.setCancelable(false);

    }

    @Override
    public void onBackPressed() {
        if (web.canGoBack()) {
            web.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private class vaa extends AsyncTask<Void, Void, Void> {

        Elements element;

        @Override
        protected Void doInBackground(Void... voids) {


            try {
                Document doc = Jsoup.connect(url).get();
                element = doc.getElementsByClass("post-content");
            } catch (IOException ignored) {

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            String str = element.toString();
            String str2 = str.replace("Catégorie:", "");
            String str3 = str2.replace("Actualités", "");
            web.loadDataWithBaseURL(null, str3, "text/html", "utf-8", null);
            progressDialog.dismiss();
        }
    }
}
