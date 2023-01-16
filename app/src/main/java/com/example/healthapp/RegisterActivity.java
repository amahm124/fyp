package com.example.healthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private Button btn_signup;
    private TextInputLayout email,password;
    private TextView Sign_in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        auth=FirebaseAuth.getInstance();
        email=findViewById(R.id.reg_email);
        password=findViewById(R.id.reg_password);
        btn_signup=findViewById(R.id.btn_register);
        Sign_in=findViewById(R.id.tv_signin);
        Sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginAxtivity.class));

            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

    }

    private void register() {
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
            auth.createUserWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    System.out.println(task.isSuccessful());
                    if(task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this,"User registred successfly",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this,Drawel_activity.class));
                    }else {
                        System.out.println(task.getException().getMessage());
                        Toast.makeText(RegisterActivity.this,"Registration Failed "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();


                    }
                }
            });


    }}
}