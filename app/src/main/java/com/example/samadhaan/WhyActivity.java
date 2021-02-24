package com.example.samadhaan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class WhyActivity extends AppCompatActivity {
    private PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_why);
        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("why.pdf")
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }
}