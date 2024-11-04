package com.example.helloworld;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class AddCountryActivity extends AppCompatActivity {

    private Spinner spinnerCountry;
    private EditText editTextPopulation;
    private ImageView imageViewFlag;
    private Button buttonCreateCountry, btnSelectFlag;
    private static final int PICK_IMAGE_REQUEST = 1;
    private Uri flagImageUri; // Biến lưu trữ URI của ảnh được chọn từ b nhớ

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        // Khởi tạo các thành phần
        spinnerCountry = findViewById(R.id.spinner_country_list);
        editTextPopulation = findViewById(R.id.edit_text_population);
        imageViewFlag = findViewById(R.id.image_view_flag);
        btnSelectFlag = findViewById(R.id.button_select_flag);
        buttonCreateCountry = findViewById(R.id.button_add_country);

        // Thiết lập Adapter cho Spinner để hiển thị tên các quốc gia
        String[] countryNames = {"Vietnam", "USA", "Japan", "Germany","ThaiLan","Laos","Campuchia"};
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                countryNames);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCountry.setAdapter(spinnerAdapter);

        // Sự kiện click nút Select Flag để chọn ảnh
        btnSelectFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openImagePicker(); // Mở trình chọn ảnh
            }
        });

        // Sự kiện click vào nút "Add Country"
        buttonCreateCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedCountry = spinnerCountry.getSelectedItem().toString();
                String populationText = editTextPopulation.getText().toString();

                if (populationText.isEmpty()) {
                    Toast.makeText(AddCountryActivity.this, "Please enter population", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (flagImageUri == null) {
                    Toast.makeText(AddCountryActivity.this, "Please select a flag image", Toast.LENGTH_SHORT).show();
                    return;
                }

                int population = Integer.parseInt(populationText);

                // Tạo Intent để gửi dữ liệu trở về MainActivity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("country_name", selectedCountry);
                resultIntent.putExtra("country_population", population);
                resultIntent.putExtra("country_flag_uri", flagImageUri.toString()); // Gửi URI của ảnh

                // Kết quả OK và quay lại MainActivity
                setResult(RESULT_OK, resultIntent);
                finish(); // Đóng AddCountryActivity và quay lại MainActivity
            }
        });
    }

    // Mở trình chọn ảnh
    private void openImagePicker() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            flagImageUri = data.getData(); // Lưu trữ URI của ảnh đã chọn
            try {
                // Hiển thị ảnh đã chọn trong ImageView
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), flagImageUri);
                imageViewFlag.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}