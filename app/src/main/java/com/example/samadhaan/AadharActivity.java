package com.example.samadhaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AadharActivity extends AppCompatActivity {

    private Button returnn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aadhar);

        returnn=findViewById(R.id.returnn);
        returnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AadharActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}