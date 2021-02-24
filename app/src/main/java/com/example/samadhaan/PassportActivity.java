package com.example.samadhaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PassportActivity extends AppCompatActivity {
    private Button returnn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passport);

        returnn2=findViewById(R.id.returnn2);
        returnn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(PassportActivity.this,CategoryActivity.class);
                startActivity(intent);
            }
        });
    }
}