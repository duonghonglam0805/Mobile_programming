package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChuyenDoiLich extends AppCompatActivity {

    // Bài tập table layout schedule
    // Khai báo biến giao diệnn
    EditText editDuongLich ;
    Button chuyen;
    TextView txtAmLich;

    @Override
    protected void onCreate(Bundle savedInstanceState) { // Hàm bắt buộc trong Android để chạy chương trình
        super.onCreate(savedInstanceState);
        setContentView(R.layout.baitap_table_layout_schedule);
        // Ánh xạ
        editDuongLich = findViewById(R.id.ediTextDuonglich);
        chuyen = findViewById(R.id.buttonChuyen);
        txtAmLich = findViewById(R.id.textAmlich);

        chuyen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String can = "", chi = "";
                int namduong = Integer.parseInt(editDuongLich.getText().toString());
                switch (namduong%10)
                {
                    case 0: can ="Canh";
                        break;
                    case 1: can ="Tân";
                        break;
                    case 2: can ="Nhâm";
                        break;
                    case 3: can ="Qúy";
                        break;
                    case 4: can ="Giáp";
                        break;
                    case 5: can ="Ất";
                        break;
                    case 6: can ="Bính";
                        break;
                    case 7: can ="Định";
                        break;
                    case 8: can ="Mậu";
                        break;
                    case 9: can ="Ký";
                        break;
                }
                switch (namduong%12)
                {
                    case 0: chi = "Thân"; break;
                    case 1: chi = "Đậu"; break;
                    case 2: chi = "Tuất"; break;
                    case 3: chi = "Hợi"; break;
                    case 4: chi = "Tý"; break;
                    case 5: chi = "Sửu"; break;
                    case 6: chi = "Dần"; break;
                    case 7: chi = "Mạo"; break;
                    case 8: chi = "Thìn"; break;
                    case 9: chi = "Tỵ"; break;
                    case 10: chi = "Ngọ"; break;
                    case 11: chi = "Mùi"; break;
                }
                txtAmLich.setText(can + " " + chi);
            }
        });
    }

}