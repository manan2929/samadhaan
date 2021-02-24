package com.example.samadhaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;

public class OtpActivity extends AppCompatActivity {

    private Button back;
    private EditText et_pass;
    private Button resend,verify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
       /* et_pass=findViewById(R.id.et_pass);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OtpActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        resend=findViewById(R.id.resend);
        verify=findViewById(R.id.verify);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String verificationCode=et_pass.getText().toString();
                if (verificationCode.isEmpty()){
                    return;
                }
                signInUser();

            }
        });

    }

    private void signInUser(PhoneAuthCredential credential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
    }*/


}}