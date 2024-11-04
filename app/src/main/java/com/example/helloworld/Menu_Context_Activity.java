package com.example.helloworld;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Menu_Context_Activity extends AppCompatActivity {

    Button btnSelectColor ;
    ConstraintLayout screen ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu_context);

        btnSelectColor = (Button) findViewById(R.id.buttonSelectColor);
        screen = (ConstraintLayout) findViewById(R.id.manhinh);
        // Đăng ký view cho context menu, càn phải register để biết menuContext cho sự kiện nào
        registerForContextMenu(btnSelectColor);
    }

    // hàm tạo menu context
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.menu_context, menu); // View menu
        menu.setHeaderTitle("Select Color");
        menu.setHeaderIcon(R.mipmap.ic_launcher);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // hàm tương tác với các item trong menu
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        int colorPink = ContextCompat.getColor(this, R.color.pink);
        if (id == R.id.action_pink){
            screen.setBackgroundColor(colorPink);
            return true;
        } else if (id == R.id.action_yellow) {
            screen.setBackgroundColor(Color.YELLOW);
            return true;
        } else if (id == R.id.action_blue) {
            screen.setBackgroundColor(Color.BLUE);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}