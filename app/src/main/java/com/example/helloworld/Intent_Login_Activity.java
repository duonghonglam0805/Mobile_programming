package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Intent_Login_Activity extends AppCompatActivity {

    Button btnRegister ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_login);
        btnRegister = findViewById(R.id.buttonChuyenRegister);
        ClickOpenFormRegister();
    }

    public void ClickOpenFormRegister(){
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai báo intent
                Intent myIntent = new Intent(Intent_Login_Activity.this, Intent_Register_activity.class);
                // Khởi động
                startActivity(myIntent);
            }
        });
    }
}