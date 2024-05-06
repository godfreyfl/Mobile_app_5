package com.example.practice_5_new;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class BananaCategoryActivity extends AppCompatActivity {
    private Spinner spinnerBananaVarieties;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banana_category);

        spinnerBananaVarieties = findViewById(R.id.spinnerBananaVarieties);

        List<String> bananaVarieties = new ArrayList<>();
        bananaVarieties.add("Кавендиш");
        bananaVarieties.add("Грос Мишель");
        bananaVarieties.add("Блю-Джей");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bananaVarieties);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerBananaVarieties.setAdapter(adapter);

        spinnerBananaVarieties.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedVariety = bananaVarieties.get(position);
                // Здесь можно добавить дополнительную логику при выборе сорта банана
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Действие при отсутствии выбора
            }
        });
    }
}
