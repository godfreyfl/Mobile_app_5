package com.example.practice_5_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

public class CategoryAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> categories;

    public CategoryAdapter(@NonNull Context context, int resource, @NonNull List<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.categories = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_category, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.textView);

        String category = categories.get(position);

        // Установка изображения и текста
        if (category.equals("Яблоки")) {
            imageView.setImageResource(R.drawable.apple);
        } else if (category.equals("Груши")) {
            imageView.setImageResource(R.drawable.pear);
        } else if (category.equals("Апельсины")) {
            imageView.setImageResource(R.drawable.orange);
        } else if (category.equals("Бананы")) {
            imageView.setImageResource(R.drawable.banana);
        }


        textView.setText(category);

        return convertView;
    }
}
