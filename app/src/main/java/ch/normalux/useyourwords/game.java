package ch.normalux.useyourwords;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class game extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        webView = findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://wordsgame.lol/");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.unlockAnswer:
                webView.loadUrl(
                    "javascript:(function(){" +
                    "let inputs = document.getElementsByName('radio');" +
                    "for(var i = 0; i < inputs.length; i++){" +
                    "inputs[i].disabled = false;" +
                    "}" +
                    "})()");
                return true;
            case R.id.showHouse:
                webView.loadUrl(
                    "javascript:(function(){" +
                    "let labels = document.getElementsByTagName('label');" +
                    "for(var i = 0; i < labels.length; i++){" +
                    "if(labels[i].htmlFor == 'HOUSE'){" +
                    "labels[i].style.backgroundColor = 'coral';" +
                    "}" +
                    "}" +
                    "})()");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {

    }
}
