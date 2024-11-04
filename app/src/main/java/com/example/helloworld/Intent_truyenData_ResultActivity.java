package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Intent_truyenData_ResultActivity extends AppCompatActivity {

    TextView txtResult ;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_truyen_data_result);
        AnhXa();
        NhanIntent();
        Back();
    }
    public void AnhXa(){
        txtResult = findViewById(R.id.textViewResult);
        btnBack = findViewById(R.id.buttonBack);
    }
    // Nhận Intent
    public void NhanIntent() {
        Intent myIntent = getIntent();
        // Lấy Bundle khỏi intent
        Bundle myBundle = myIntent.getBundleExtra("mypackage");
        // Lấy dữ liệu khỏi bundle
        int a = myBundle.getInt("numbera");
        int b = myBundle.getInt("numberb");
        // Tiến hành giải phương trình
        String nghiem = "";
        if(a==0 && b == 0){
            nghiem = "PT vô số nghiệm";
        } else if (a == 0 && b != 0) {
            nghiem = "PT vô nghiệm";
        }else {
            nghiem = "Nghiệm = PT" + (-1.0) * b/a;
        }
        txtResult.setText(nghiem);
    }

    // Back
    public void Back(){
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }



}