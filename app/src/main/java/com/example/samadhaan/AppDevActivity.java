package com.example.samadhaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class AppDevActivity extends AppCompatActivity {
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_dev);
        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("appdev.pdf")
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
}