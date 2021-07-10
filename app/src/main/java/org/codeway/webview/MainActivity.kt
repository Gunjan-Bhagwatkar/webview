package org.codeway.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.URLUtil
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    lateinit var mywebview: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mywebview: WebView = findViewById(R.id.mywebview)
        val etURL: EditText = findViewById(R.id.eturl)
        val btnGo: ImageButton = findViewById(R.id.btngo)
        val btnhome: ImageButton = findViewById(R.id.btnhome)

        val btnfacebook: ImageButton = findViewById(R.id.btnfb)
        val btninstagram: ImageButton = findViewById(R.id.btninsta)
        val btntwitter: ImageButton = findViewById(R.id.btntwit)

        val btnback:ImageButton = findViewById(R.id.btnback)
        val btnfor: ImageButton = findViewById(R.id.btnfor)

        mywebview.webViewClient = WebViewClient()

        btnback.setOnClickListener{
            if (mywebview.canGoBack())
            {
                mywebview.goBack()
            }
            else
            {
                super.onBackPressed()
            }
        }
        btnfor.setOnClickListener {
            if(mywebview.canGoForward())
            {
                mywebview.goForward()
            }
        }

        btnGo.setOnClickListener {
            val siteurl: String = etURL.text.toString()
            if (URLUtil.isValidUrl(siteurl))
            {
                mywebview.loadUrl(siteurl)
            }
            else
            {
                mywebview.loadUrl("https://www.google.com/search?q=$siteurl")
            }
        }
        btnhome.setOnClickListener(){
            mywebview.loadUrl("https://www.google.co.in")
        }
        btnfacebook.setOnClickListener(){
            mywebview.loadUrl("https://m.facebook.com/")
        }
        btninstagram.setOnClickListener(){
            mywebview.loadUrl("https://www.instagram.com")
        }
        btntwitter.setOnClickListener(){
            mywebview.loadUrl("https://twitter.com/?lang=en")
        }

        mywebview.settings.javaScriptEnabled = true
    }
    override fun onBackPressed()
    {

        if (mywebview.canGoBack())
        {
            mywebview.goBack()
        }
        else
        {
            super.onBackPressed()
        }
    }

}