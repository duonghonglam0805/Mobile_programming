package com.example.helloworld;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class SQLite extends AppCompatActivity {
    // Khai báo các biến giao diện
    EditText edtMalop, edtTenlop, edtSiso;
    Button btnInsert, btnDelete, btnUpdate, btnQuery;
    // Khai báo list view
    ListView lvlophoc ;
    ArrayList<String> myList;
    ArrayAdapter<String> myAdapter;
    SQLiteDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sqlite);
        AnhXa();
        CreateListView();
        CreateTable();
        ClickInsertButton();
        ClickDeleteButton();
        ClickUpdateButton();
        ClickQueryButton();
    }

    public void AnhXa(){
        edtMalop = findViewById(R.id.editTextMalop);
        edtTenlop = findViewById(R.id.editTextTenlop);
        edtSiso = findViewById(R.id.editTextSiso);
        btnInsert = findViewById(R.id.buttonInsert);
        btnDelete = findViewById(R.id.buttonDelete);
        btnUpdate = findViewById(R.id.buttonUpdate);
        btnQuery = findViewById(R.id.buttonQuery);
        lvlophoc = findViewById(R.id.listViewLophoc);
    }

    // Tạo listview
    public  void CreateListView () {
        myList = new ArrayList<>();
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, myList);
        lvlophoc.setAdapter(myAdapter);
    }

    // Create table
    public  void CreateTable (){
        myDatabase = openOrCreateDatabase("qllophoc.db", MODE_PRIVATE, null);
        // Tạo table để chứa dữ liệu
        try {
            String sql = "CREATE TABLE tableLop(malop TEXT primary key, tenlop TEXT, siso INTEGER)";
            myDatabase.execSQL(sql);
        }catch (Exception e){
            Log.e("Error", "Table đã tồn tại");
        }
    }

    // Chức năng insert
    public void ClickInsertButton(){
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtMalop.getText().toString();
                String tenlop = edtTenlop.getText().toString();
                int siso = Integer.parseInt(edtSiso.getText().toString());
                // Trước khi truyền các data này vào table thì nó phải được lưu trữ tại 1 bản ghi là ContentValues
                ContentValues myValue = new ContentValues();
                // Cho mấy cái data vào bảng
                myValue.put("malop", malop);
                myValue.put("tenlop", tenlop);
                myValue.put("siso", siso);
                String msg = "";
                if (myDatabase.insert("tablelop", null, myValue)==-1)
                {
                     msg = "Fail to insert";
                }else {
                    msg = "Insert record successfully";
                }
                Toast.makeText(SQLite.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Chức năng Delete
    public void ClickDeleteButton(){
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String malop = edtMalop.getText().toString();
                int n = myDatabase.delete("tablelop", "malop = ?", new String[]{malop});
                String msg = "";
                if (n ==0){
                    msg = "No record to delete";
                }else {
                    msg = n + "record is deleted";
                }
                Toast.makeText(SQLite.this,  msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Chức năng update
    public void ClickUpdateButton(){
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int siso = Integer.parseInt(edtSiso.getText().toString());
                String malop = edtMalop.getText().toString();
                ContentValues myValue = new ContentValues();
                myValue.put("siso", siso);
                int n = myDatabase.update("tablelop", myValue, "malop = ?", new String[]{malop});
                String msg = "";
                if (n ==0){
                    msg = "No record to update";
                }else {
                    msg = n + "record is update";
                }
                Toast.makeText(SQLite.this,  msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Chức năng query
    public void ClickQueryButton () {
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear để có thể mỗi lần click vào button thì sẽ lấy dữ liệu từ đâu
                myList.clear();
                // truy vvan sẽ trả về một biến con trỏ gọi là Cursỏ
                Cursor c = myDatabase.query("tablelop", null, null, null, null, null, null);
                // đọc dữ liệu cuả con trỏ
                c.moveToNext(); // Di chuyển con trỏ veef bản ghi đầu tiên
                String data = "";
                while (c.isAfterLast() == false)
                {
                    data = c.getString(0) + "-" + c.getString(1) + "-" + c.getString(2);
                    c.moveToNext();//di chuyen đến ban ghi kế tiếp
                    myList.add(data); // Toàn bộ dữ liệ trong table sẽ được add vo myList
                }
                c.close();
                myAdapter.notifyDataSetChanged();
            }
        });
    }
}