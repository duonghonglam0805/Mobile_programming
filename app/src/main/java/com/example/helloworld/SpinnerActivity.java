package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    private static final int ADD_COUNTRY_REQUEST = 1;

    private Spinner countrySpinner;
    private ListView countryListView;
    private CountryAdapter countryAdapter;
    private List<Country> countryList;
    private Button btnAddCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner2);

        // Khởi tạo ListView, Spinner và nút Add Country
        countryListView = findViewById(R.id.listview_country);
        btnAddCountry = findViewById(R.id.btn_add_country);

        // Tạo danh sách các quốc gia mặc định
        countryList = new ArrayList<>();
        countryList.add(new Country("Vietnam", 97000000, Uri.parse("android.resource://com.example.helloworld/" + R.mipmap.vn)));
        countryList.add(new Country("USA", 331000000, Uri.parse("android.resource://com.example.helloworld/" + R.mipmap.usa)));
        countryList.add(new Country("Japan", 126000000, Uri.parse("android.resource://com.example.helloworld/" + R.mipmap.uk)));
        countryList.add(new Country("Germany", 83000000, Uri.parse("android.resource://com.example.helloworld/" + R.mipmap.vn)));

        // Thiết lập adapter cho ListView
        countryAdapter = new CountryAdapter(this, countryList);
        countryListView.setAdapter(countryAdapter);

        // Sự kiện click nút Add Country
        btnAddCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở AddCountryActivity để thêm quốc gia
                Intent intent = new Intent(SpinnerActivity.this, AddCountryActivity.class);
                startActivityForResult(intent, ADD_COUNTRY_REQUEST);
            }
        });
    }

    // Xử lý kết quả trả về từ AddCountryActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_COUNTRY_REQUEST && resultCode == RESULT_OK) {
            if (data != null) {
                String countryName = data.getStringExtra("country_name");
                int population = data.getIntExtra("country_population", 0);
                String flagUriString = data.getStringExtra("country_flag_uri");
                Uri flagUri = Uri.parse(flagUriString);

                // Thêm quốc gia mới vào danh sách và cập nhật ListView
                Country newCountry = new Country(countryName, population, flagUri);
                countryList.add(newCountry);
                countryAdapter.notifyDataSetChanged();
            }
        }
    }
}