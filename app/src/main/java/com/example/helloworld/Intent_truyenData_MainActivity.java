package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Intent_truyenData_MainActivity extends AppCompatActivity {

    EditText edtA, edtB;
    Button btnResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_truyen_data_main);
        AnhXa();
        ClickResult();
    }

    public void AnhXa(){
        edtA = findViewById(R.id.editTextA);
        edtB = findViewById(R.id.editTextB);
        btnResult = findViewById(R.id.buttonResult);
    }

    public void ClickResult(){
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Khai bao intent
                Intent myIntent = new Intent(Intent_truyenData_MainActivity.this, Intent_truyenData_ResultActivity.class);
                int a = Integer.parseInt(edtA.getText().toString());
                int b = Integer.parseInt(edtB.getText().toString());
                //Đóng gói data vào Bundle
                Bundle myBundle = new Bundle();
                // Đưa dữ lieu vào bundle
                myBundle.putInt("numbera", a);
                myBundle.putInt("numberb", b);
                // Đưa giữ liiệu vào Intent
                myIntent.putExtra("mypackage", myBundle);
                // khởi động intent
                startActivity(myIntent);
            }
        });
    }
}