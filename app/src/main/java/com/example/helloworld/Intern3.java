package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Intern3 extends AppCompatActivity {

    EditText edtData, edtResult ;
    Button btnRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intern3);
        AnhXa();
        ClickButtonRequest();
    }

    public void AnhXa(){
        edtData = findViewById(R.id.editTextData);
        edtResult = findViewById(R.id.editTextKetqua);
        btnRequest = findViewById(R.id.buttonRequest);
    }

    // sự kiện click request kết quả
    public void ClickButtonRequest(){
        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khai báo intent
                Intent myIntent = new Intent(Intern3.this, Intent3_result.class);
                // Lấy data từ editText
                int data = Integer.parseInt(edtData.getText().toString());
                // Đưa dữ liệu vào Intent
                myIntent.putExtra("data", data);
                // Khởi động intent
                startActivityForResult(myIntent, 99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 99 && resultCode == 33){
            int kq = data.getIntExtra("kq", 0);
            edtResult.setText("Giá trị gốc là: "+kq);
        }
        if(requestCode == 99 && resultCode == 34){
            int kq = data.getIntExtra("kq", 0);
            edtResult.setText("Giá trị BP là: " +kq);
        }

    }
}