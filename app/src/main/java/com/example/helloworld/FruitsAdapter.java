package com.example.helloworld;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitsAdapter extends BaseAdapter {

    private Context context ;
    private int layout; // mỗi dòng list view muốn hiển thị layout như thế nào thì tự custom thong qua layout này
    private List<Fruits> FruitsList; // Lay du lieu muon hien thi

    // Tạo constructor


    public FruitsAdapter(Context context, int layout, List<Fruits> fruitsList) {
        this.context = context;
        this.layout = layout;
        FruitsList = fruitsList;
    }

    @Override
    public int getCount() { // getCount số dòng muốn hiển thị ra ngoài
        return FruitsList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) { // 1 cái dòng đẻ nó đổ ra view
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // convertView này sẽ chứa layout, chọn layout sẽ hiển thị ở mỗi dòng sẽ như thế nào
        convertView = inflater.inflate(layout, null);

        // Ánh xạ view
        TextView txtName = (TextView) convertView.findViewById(R.id.textView_name);
        TextView txtDescription = (TextView)  convertView.findViewById(R.id.textView_description);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView_fruit);

        // Gán giá trị
        Fruits fruit = FruitsList.get(position);

        txtName.setText(fruit.getName());
        txtDescription.setText(fruit.getDescription());
        imageView.setImageResource(fruit.getImage());
        return convertView;
    }
}
