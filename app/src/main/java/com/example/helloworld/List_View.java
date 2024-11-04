package com.example.helloworld;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List_View extends AppCompatActivity {
    // Khai báo
    ListView listBCC;
    Button btnAdd ;
    Button btnEdit ;
    EditText edtSubject;
    ArrayList<String> subjects = new ArrayList<>();
    ArrayAdapter<String> adapter;
    int vitri = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        AnhXa();
        setUpListView();
    }
    // Hàm ánh xạ
    private void AnhXa() {
        listBCC = findViewById(R.id.ListViewBCC); // Kết nối ListView với layout
        btnAdd = findViewById(R.id.buttonAddSubject);
        edtSubject = findViewById(R.id.editTextSubject);
        btnEdit = findViewById(R.id.buttonEditSubject);
    }

    // Hàm tạo ListView
    private void setUpListView() {
        subjects = new ArrayList<>();
        subjects.add("Mathematics");
        subjects.add("Physics");
        subjects.add("Chemistry");
        subjects.add("Biology");
        // Tạo ArrayAdapter để hiển thị dữ liệu trong ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, subjects);
        // Gán adapter cho ListView
        listBCC.setAdapter(adapter);
        // Su kien click tren tung item cua arr
        listBCC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // position: trả về vị trí khi người dùng click trên listview , bắt đầu từ index là 0
                Toast.makeText(List_View.this, subjects.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        // Su kien long click
        listBCC.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(List_View.this, "Long click: " + subjects.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = edtSubject.getText().toString();
                subjects.add(subject);
                // cap nhat lai adapter de no hien thi du lieu ra man hinh khi du lieu thay doi
                adapter.notifyDataSetChanged();
                edtSubject.setText("");
            }
        });

        // Chinh sua
            // Su kien chon item va hien thi len o edit text
        listBCC.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtSubject.setText(subjects.get(position));
                vitri = position;
            }
        });
            // Su kien btnEdit
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subjects.set(vitri,edtSubject.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });


        // Xoa
        listBCC.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                // Tạo hộp thoại xác nhận
                AlertDialog.Builder builder = new AlertDialog.Builder(List_View.this);
                builder.setTitle("Confirm Delete");
                builder.setMessage("Are you sure you want to delete this item?");

                // Nút OK
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Xóa item
                        subjects.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });

                // Nút Cancel
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Đóng hộp thoại, không xóa
                        dialog.dismiss();
                    }
                });

                // Hiển thị hộp thoại
                builder.create().show();
                return true;
            }
        });
    }
}
