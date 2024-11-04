package com.example.helloworld;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tonghop extends AppCompatActivity {

    private EditText edtFullName, edtCCCD, edtAddInfor;
    private RadioGroup radioCertification;
    private CheckBox checkBoxRead, checkBoxListen, checkBoxSport;
    private Button btnSend;

    protected long backPressTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tonghop);
        AnhXa();
        ClickButtonSend();
    }
    public void AnhXa() {
        edtFullName = (EditText) findViewById(R.id.editTextFullName);
        edtCCCD = (EditText) findViewById(R.id.editTextCCCD);
        radioCertification = (RadioGroup) findViewById(R.id.radioGroup);
        checkBoxRead = (CheckBox) findViewById(R.id.checkBoxRead);
        checkBoxListen = (CheckBox) findViewById(R.id.checkBoxListen);
        checkBoxSport = (CheckBox) findViewById(R.id.checkBoxSport);
        edtAddInfor = (EditText) findViewById(R.id.editTextMultiLineAddInfor);
        btnSend = (Button) findViewById(R.id.buttonSend);
    }
    // Xử lý button
    public void ClickButtonSend() {
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy thông tin Họ tên
                String fullName = edtFullName.getText().toString();
                if (fullName.length() < 3) {
                    Toast.makeText(Tonghop.this, "Full name at least 3 characters", Toast.LENGTH_SHORT).show();
                    edtFullName.requestFocus(); // Để người dùng khi nhập sai thì con chuột nó hiện vào cái chỗ đang nhập sai
                    edtFullName.selectAll(); //Booi đen
                    return;
                }

                // Lấy thông tin CCCD
                String CCCD = edtCCCD.getText().toString();
                if (CCCD.length() != 9) {
                    Toast.makeText(Tonghop.this, "CCCD must be equal 9", Toast.LENGTH_SHORT).show();
                    edtCCCD.requestFocus();
                    edtCCCD.selectAll();
                    return;
                }

                // Lấy thông tin bằng cấp
                int idSelect = radioCertification.getCheckedRadioButtonId(); // Trả về id của radio được chọn trong group
                RadioButton radioSelect = findViewById(idSelect);
                String certi = radioSelect.getText().toString();

                // Lấy thông tin sở thích
                String hobbies = "";
                if (checkBoxRead.isChecked()) {
                    hobbies += checkBoxRead.getText().toString() + "-";
                }
                if (checkBoxListen.isChecked()) {
                    hobbies += checkBoxListen.getText().toString() + "-";
                }
                if (checkBoxSport.isChecked()) {
                    hobbies += checkBoxSport.getText().toString() + "-";
                }

                // Lấy thông tin bổ sung
                String information = edtAddInfor.getText().toString();
                String tonghop = fullName + "\n" + CCCD + "\n" + certi + "\n" + hobbies + "\n";
                tonghop += "----------Additional Information----------\n";
                tonghop += information + "\n";
                tonghop += "--------------------------------------------";

                AlertDialog.Builder myDialog = new AlertDialog.Builder(Tonghop.this);
                myDialog.setTitle("Personal Information");
                myDialog.setMessage(tonghop);
                myDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                myDialog.create().show();
            }
        });
}

    // Hộp thoại thoát khỏi ứng dụng
//    @Override
//    public void onBackPressed() {
//        //Tạo dialog
//        AlertDialog.Builder exitDialog = new AlertDialog.Builder(Tonghop.this);
//        exitDialog.setTitle("Question");
//        exitDialog.setMessage("Do you want to exit?");
//        exitDialog.setIcon(R.drawable.shin);
//        exitDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();// Thoát ứng dụng
//            }
//        });
//        exitDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.cancel();
//            }
//        });
//        exitDialog.create().show(); //Hiển thị dialog
//    }


    @Override
    public void onBackPressed() {

        if (backPressTime + 2000 > System.currentTimeMillis() ){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();
        }
        backPressTime = System.currentTimeMillis();
    }
}