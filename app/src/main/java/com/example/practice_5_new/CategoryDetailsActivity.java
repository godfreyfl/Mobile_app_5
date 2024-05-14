package com.example.practice_5_new;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class CategoryDetailsActivity extends AppCompatActivity {
    private List<String> items;
    private TextView textView;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_details);

        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);

        String category = getIntent().getStringExtra("category"); // Получение названия категории из интента, переданного из предыдущей активности.
        setTitle(category);

        items = new ArrayList<>();
        if (category.equals("Яблоки")) {
            items.add("Голден");
            items.add("Гала");
            items.add("Хоней Крисп");
            items.add("Ренет Симиренко");
            items.add("Фуджи");
        } else if (category.equals("Груши")) {
            items.add("Гвидон");
            items.add("Велеса");
            items.add("Зимняя");
            items.add("Чижовская");
        } else if (category.equals("Апельсины")) {
            items.add("Красные сицилийские");
            items.add("Севильский");
            items.add("Кара-кара");
            items.add("Клементины");
        }

        StringBuilder sb = new StringBuilder(); // для построения строки из элементов списка
        for (String item : items) { // Перебор элементов списка и добавление их в StringBuilder
            sb.append(item).append("\n");
        }
        textView.setText(sb.toString());
    }

    public void addItem(View view) {
        String newItem = editText.getText().toString().trim();
        if (!newItem.isEmpty()) {
            items.add(newItem);
            updateTextView();
            editText.setText(""); // Очистка editText после добавления элемента
        }
    }

    public void removeItem(View view) {
        if (!items.isEmpty()) {
            items.remove(items.size() - 1); // Удаление последнего элемента из списка.
            updateTextView();
        }
    }

    private void updateTextView() {
        StringBuilder sb = new StringBuilder();
        for (String item : items) {
            sb.append(item).append("\n");
        }
        textView.setText(sb.toString());
    }
}




