package com.example.helloworld;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu_Popup_Activity extends AppCompatActivity {

    Button btnShowMenu ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_popup);

        btnShowMenu = (Button) findViewById(R.id.buttonMenuShowPopup);
        btnShowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowMenu();
            }
        });
    }

    private void ShowMenu(){
        PopupMenu popupMenu = new PopupMenu(this, btnShowMenu); // khởi tạo popup menu. Tham số thứ nhất là context, tham số thứ 2 là view
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu()); // Gọi view của menu : tham số thứ nhất là view của menu là file xml, tham số thứ 2 cần trả vè menu nhưng ở đây là hàm nên sẽ trả về thông qua popupMenu.getMenu()

        // Bắt sự kiện khi click vào từng item của menu
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_add){
                    btnShowMenu.setText("Menu Add");
                    return true;
                } else if (id == R.id.action_edit) {
                    btnShowMenu.setText("Menu Edit");
                    return true;
                } else if (id == R.id.action_delete) {
                    btnShowMenu.setText("Menu Delete");
                    return true;
                }
                return false;
            }
        });
        popupMenu.show(); // gọi hàm show để hiển thị lên
    }
}