package com.example.samadhaan;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.hbb20.CountryCodePicker;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    private EditText et_email, et_password,et_phone;
    private Button login, signUp;
    private Toolbar toolbar;
    private Button signup;
    private CountryCodePicker ccp;
    private FirebaseAuth auth;
    private Button email;
    private EditText et_emailsignup, et_passsignp;
    private Button proceed;
    private Dialog categoryDialog,loadingDialog;
    private Button signupbtn,back;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        try {
            et_emailsignup = categoryDialog.findViewById(R.id.et_emailsignup);
        }catch (NullPointerException ignored){

        }
        try {
            et_passsignp = categoryDialog.findViewById(R.id.et_passsignup);
        }catch (NullPointerException ignored){

        }
        try {
            signupbtn = categoryDialog.findViewById(R.id.signupbtn);
        }catch (NullPointerException ignored){

        }
        auth = FirebaseAuth.getInstance();
        final Intent intent=new Intent(this,IDActivity.class);

        auth=FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!= null){
            // user is already signed in
            // open category intent
            startActivity(intent);
            finish();
            return;
        }
        /*try {
            signupbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String email = et_emailsignup.getText().toString().trim();
                    String password = et_passsignp.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (password.length() < 6) {
                        Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(LoginActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {
                                        Toast.makeText(LoginActivity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {
                                        startActivity(new Intent(LoginActivity.this, CategoryActivity.class));
                                        Toast.makeText(LoginActivity.this, "cool", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                }
                            });
                }
            });
        }catch (NullPointerException ignored){

        }*/

           /* try {
                signupbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(LoginActivity.this, "cool", Toast.LENGTH_SHORT).show();
                    }
                });
            }catch (NullPointerException ignored){

            }

        signUp = findViewById(R.id.signuppp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryDialog = new Dialog(LoginActivity.this);
                categoryDialog.setContentView(R.layout.add_category_dialog);
                categoryDialog.show();
            }
        });*/

        ccp=findViewById(R.id.ccp);
        et_phone=findViewById(R.id.et_phone);
        proceed = findViewById(R.id.proceed );

        loadingDialog = new Dialog(this);
        loadingDialog.setContentView(R.layout.loading);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Objects.requireNonNull(loadingDialog.getWindow()).setBackgroundDrawable(getDrawable(R.drawable.rounded_corners));
        }
        Objects.requireNonNull(loadingDialog.getWindow()).setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        loadingDialog.setCancelable(false);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNo=et_phone.getText().toString();
                loadingDialog.show();
                if (phoneNo.isEmpty()){
                    loadingDialog.dismiss();
                    et_phone.setError("Enter Phone Number");

                }
                else {
                    PhoneAuthProvider.getInstance().verifyPhoneNumber( "+91"+phoneNo, 60, TimeUnit.SECONDS, LoginActivity.this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            loadingDialog.dismiss();
                            signInUser(phoneAuthCredential);
                            //Toast.makeText(LoginActivity.this, "", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                            loadingDialog.dismiss();
                            Toast.makeText(LoginActivity.this, "Phone Verification Unsuccessful"+e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCodeSent(@NonNull final String verificationId, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            super.onCodeSent(verificationId, forceResendingToken);
                            final Dialog dialog=new Dialog(LoginActivity.this);
                            dialog.setContentView(R.layout.activity_otp);

                            //Button resend=dialog.findViewById(R.id.resend);

                            Button verify=dialog.findViewById(R.id.verify);
                            final EditText et_pass=dialog.findViewById(R.id.et_pass);
                            verify.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String verificationCode=et_pass.getText().toString();
                                    if (verificationCode.isEmpty()){
                                        return;
                                    }
                                    PhoneAuthCredential credential= PhoneAuthProvider.getCredential(verificationId,verificationCode);
                                    signInUser(credential);
                                }
                            });
                            dialog.show();
                            back=dialog.findViewById(R.id.back);
                            back.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                        }
                    });
                }

            }
        });
        email = findViewById(R.id.contemail);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, EmailActivity.class);
                startActivity(intent);
            }
        });
    }

    private void signInUser(PhoneAuthCredential credential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "on Complete Success", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LoginActivity.this,IDActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "on Complete"+task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
        /*login=findViewById(R.id.login);
        signUp=findViewById(R.id.signUp);
        et_email=findViewById(R.id.et_email);
        et_password=findViewById(R.id.et_password);

        firebaseAuth=FirebaseAuth.getInstance();
        final Intent intent=new Intent(this,CategoryActivity.class);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_email.getText().toString().isEmpty()){
                    et_email.setError("Required");
                    return;
                }
                else{
                    et_email.setError(null);
                }


                if (et_password.getText().toString().isEmpty()){
                    et_password.setError("Required");
                    return;
                }
                else{
                    et_password.setError(null);
                }
                firebaseAuth.signInWithEmailAndPassword(et_email.getText().toString(),et_password.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    startActivity(intent);
                                    finish();
                                }
                                else {
                                    Toast.makeText(LoginActivity.this, "Sorry! Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });*/

}