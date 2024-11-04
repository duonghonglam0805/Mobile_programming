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

public class Intent3_result extends AppCompatActivity {

    EditText edtResult ;
    Button btnGoc, btnBinhPhuong;

    // Khai báo intent để nhận intent từ Intern3
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent3_result);
        AnhXa();
        // Nhận Intent
        myIntent = getIntent();
        // Lấy dữ liệu ra khỏi intent
        int data = myIntent.getIntExtra("data", 0);
        edtResult.setText(data + "");

        // Click button gốc
        btnGoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("kq",data);
                setResult(33, myIntent);
                finish(); //để nó quay trở lại intern3
            }
        });
        // Click button bình phương
        btnBinhPhuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myIntent.putExtra("kq",data*data);
                setResult(34, myIntent);
                finish(); //để nó quay trở lại intern3
            }
        });
    }

    public void AnhXa(){
        edtResult = findViewById(R.id.editTextResult);
        btnGoc = findViewById(R.id.buttonGuiGoc);
        btnBinhPhuong = findViewById(R.id.buttonGuiBinhPhuong);
    }


}