package com.example.helloworld;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {

    private Context context;
    private List<Country> countries;

    public CountryAdapter(Context context, List<Country> countries) {
        super(context, 0, countries);
        this.context = context;
        this.countries = countries;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.country_list_item, parent, false);
        }

        Country country = countries.get(position);

        TextView nameTextView = convertView.findViewById(R.id.country_name);
        TextView populationTextView = convertView.findViewById(R.id.country_population);
        ImageView flagImageView = convertView.findViewById(R.id.country_flag);

        nameTextView.setText(country.getName());
        populationTextView.setText(String.valueOf(country.getPopulation()));

        // Hiển thị ảnh từ URI
        Uri flagUri = country.getFlagUri();
        if (flagUri != null) {
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(context.getContentResolver(), flagUri);
                flagImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            flagImageView.setImageResource(R.drawable.apple); // Đặt ảnh mặc định nếu không có URI
        }

        return convertView;
    }
}

