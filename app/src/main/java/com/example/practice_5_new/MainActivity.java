package com.example.practice_5_new;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        categories = new ArrayList<>();
        categories.add("Яблоки");
        categories.add("Груши");
        categories.add("Апельсины");
        categories.add("Бананы"); // Добавление категории "Бананы"

        CategoryAdapter adapter = new CategoryAdapter(this, categories);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String category) {
                Intent intent;
                if (category.equals("Бананы")) {
                    intent = new Intent(MainActivity.this, BananaCategoryActivity.class);
                } else {
                    intent = new Intent(MainActivity.this, CategoryDetailsActivity.class);
                    intent.putExtra("category", category);
                }
                startActivity(intent);
            }
        });
    }
}
