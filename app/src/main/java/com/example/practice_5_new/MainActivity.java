package com.example.practice_5_new;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<String> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        categories = new ArrayList<>();
        categories.add("Яблоки");
        categories.add("Груши");
        categories.add("Апельсины");
        categories.add("Бананы"); // Добавление категории "Бананы"

        CategoryAdapter adapter = new CategoryAdapter(this, R.layout.item_category, categories);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categories.get(position);
                Intent intent;
                if (selectedCategory.equals("Бананы")) {
                    intent = new Intent(MainActivity.this, BananaCategoryActivity.class);
                } else {
                    intent = new Intent(MainActivity.this, CategoryDetailsActivity.class);
                    intent.putExtra("category", selectedCategory);
                }
                startActivity(intent);
            }
        });
    }
}







