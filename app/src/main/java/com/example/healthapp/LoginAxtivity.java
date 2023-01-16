package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseApp;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginAxtivity extends AppCompatActivity {
    private  FirebaseAuth auth;
    private Button  btn_Login;
    private TextInputLayout email,password;
    private TextView tv_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_axtivity);
        auth =FirebaseAuth.getInstance();
        password=findViewById(R.id.til_password);
        btn_Login=findViewById(R.id.btn_login);
        email=findViewById(R.id.til_email);
        tv_signup=findViewById(R.id.tv_signup);
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginAxtivity.this,RegisterActivity.class));
            }
        });
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }

    private void login() {
        String user =email.getEditText().getText().toString().trim();
        String pass =password.getEditText().getText().toString().trim();
        System.out.println("email"+user+"PAss"+pass);

        if(user.isEmpty()){
            email.setError("Email can not empty");

        }
        if(pass.isEmpty()){
            password.setError("Email can not empty");
        }
        else {
            auth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    System.out.println(task.isSuccessful());
                    if(task.isSuccessful()){
                        Toast.makeText(LoginAxtivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginAxtivity.this,Drawel_activity.class));
                    }else {
                        System.out.println(task.getException().getMessage());
                        Toast.makeText(LoginAxtivity.this,"Login Failed "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();


                    }
                }
            });
        }

    }
}