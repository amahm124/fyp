package com.example.healthapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private Button btn_Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        auth =FirebaseAuth.getInstance();
        btn_Logout= findViewById(R.id.btn_Logout);
        btn_Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }
    @Override
    public void onStart(){
        super.onStart();
        FirebaseUser currentUser= auth.getCurrentUser();
        if(currentUser==null){
            startActivity(new Intent(MainActivity.this,LoginAxtivity.class));
        }
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(MainActivity.this,LoginAxtivity.class));

    }
}