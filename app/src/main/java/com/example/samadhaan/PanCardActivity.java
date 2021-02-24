package com.example.samadhaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PanCardActivity extends AppCompatActivity {
    private Button returnn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pan_card);
        returnn1=findViewById(R.id.returnn1);
        returnn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PanCardActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}