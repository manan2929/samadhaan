package com.example.samadhaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CategoryActivity extends AppCompatActivity {

    private ImageView aadhar,pancard,passport,epic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        aadhar=findViewById(R.id.aadhar);
        pancard=findViewById(R.id.pancard);
        passport=findViewById(R.id.passport);
        epic=findViewById(R.id.epic);

        aadhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,AadharActivity.class);
                startActivity(intent);
            }
        });
        pancard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,PanCardActivity.class);
                startActivity(intent);
            }
        });
        passport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,PassportActivity.class);
                startActivity(intent);
            }
        });
        epic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CategoryActivity.this,epicActivity.class);
                startActivity(intent);
            }
        });

    }
}