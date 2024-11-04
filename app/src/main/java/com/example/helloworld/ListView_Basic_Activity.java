package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListView_Basic_Activity extends AppCompatActivity {

    ListView lvSubject ;
    Button btnAddSubject ;
    EditText edtSubject;
    Button btnUpdateSubject;
    // Tạo mảng để chứa dữ liệu của mình sẽ đổ ra
    int vitri;
    ArrayList <String> arrayCourses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_basic);
        AnhXa();
        SetArrayCourses();
//        ClickItem();
//        LongClickItem();
        AddSubject();
        UpdateSubject();
        DeleteSubject();
        SetAdapter();
    }


    // Khởi tạo arrayCourses và thêm các phần tử vào mảng
    public void SetArrayCourses (){
        arrayCourses = new ArrayList<>();
        arrayCourses.add("Android");
        arrayCourses.add("PHP");
        arrayCourses.add("iOS");
        arrayCourses.add("Unity");
        arrayCourses.add("ASP.NET");
    }

    // Hàm ánh xạ
    public void AnhXa(){
        lvSubject = (ListView) findViewById(R.id.listViewSubject);
        btnAddSubject = (Button) findViewById(R.id.buttonAddSubject);
        edtSubject = (EditText) findViewById(R.id.editTextSubject);
        btnUpdateSubject = (Button) findViewById(R.id.buttonUpdateSubject);
    }

    // Adapter
    public void SetAdapter () {
        // Khi muốn hiển thị ListView thì mặc định luôn phải dùng Adapter. Adapter có sẵn chỉ cần gọi ra dùng, nhưng cũng có thể custom
        ArrayAdapter adapter = new ArrayAdapter(ListView_Basic_Activity.this, android.R.layout.simple_list_item_1, arrayCourses);
        // Sẽ có 3 tham số truyền vào:
        // 1. context: cái man hinh minh muon hien thi
        // 2. Layout: Layout mà mình muốn hiển thi (Có lay out cơ bản của android
        // 3. Data: Dữ liệu đổ vào để nó kết nối
        lvSubject.setAdapter(adapter);
    }

    // Bắt sự kiện tại các item của listView
    public  void ClickItem (){
        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView_Basic_Activity.this, arrayCourses.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void LongClickItem() {
        lvSubject.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListView_Basic_Activity.this, "Long click: " + arrayCourses.get(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    // Su kien click vào button AddSubject de them dữ lieu nhap vao listView, tức là sẽ them vào arraylist arrayCourses
    public void AddSubject() {
        btnAddSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = edtSubject.getText().toString(); // Tạo 1 bien subject để lấy dữ liệu nhap vao
                arrayCourses.add(subject);
                ((ArrayAdapter) lvSubject.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    // Chỉnh sửa
    public void UpdateSubject(){
        lvSubject.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                edtSubject.setText(arrayCourses.get(position));
                vitri = position;
            }
        });
        btnUpdateSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = edtSubject.getText().toString(); // Tạo 1 bien subject để lấy dữ liệu nhap vao
                arrayCourses.set(vitri, subject);
                ((ArrayAdapter) lvSubject.getAdapter()).notifyDataSetChanged();
            }
        });
    }

    // Xóa
    public void DeleteSubject(){
        lvSubject.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                arrayCourses.remove(position);
                ((ArrayAdapter) lvSubject.getAdapter()).notifyDataSetChanged();
                return false;
            }
        });
    }
}