package com.example.helloworld;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListView_Advance extends AppCompatActivity {

    private ListView lstViewFruits ;
    ArrayList<Fruits> arrFruits;

    FruitsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view_advance);
        AnhXa();
        SetArrayFruits();
        adapter = new FruitsAdapter(this, R.layout.list_view_item, arrFruits);
        lstViewFruits.setAdapter(adapter);
    }

    public void AnhXa(){
        lstViewFruits = (ListView) findViewById(R.id.listViewFruits);
    }

    public void SetArrayFruits(){
        arrFruits = new ArrayList<>();
        arrFruits.add(new Fruits("Apple", "Green Apple", R.drawable.apple));
        arrFruits.add(new Fruits("Mango", "Yellow Mango", R.drawable.mango));
        arrFruits.add(new Fruits("Banana", "Yellow banana",R.drawable.banana));
        arrFruits.add(new Fruits("Grapes", "Purple grapes", R.drawable.grapes));

    }
}