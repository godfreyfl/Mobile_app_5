package com.example.practice_5_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context context;
    private List<String> categories;
    private OnItemClickListener onItemClickListener;

    public CategoryAdapter(Context context, List<String> categories) {
        this.context = context;
        this.categories = categories;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override // создает новый экземпляр ViewHolder на основе макета item_category.
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override // который устанавливает текст и изображение для каждого элемента списка, а также устанавливает слушатель кликов на элемент списка.
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String category = categories.get(position);
        holder.textView.setText(category);
        setImageResource(holder.imageView, category);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(category);
                }
            }
        });
    }

    @Override // возвращает общее количество элементов в списке категорий.
    public int getItemCount() {
        return categories.size();
    }

    private void setImageResource(ImageView imageView, String category) {
        switch (category) {
            case "Яблоки":
                imageView.setImageResource(R.drawable.apple);
                break;
            case "Груши":
                imageView.setImageResource(R.drawable.pear);
                break;
            case "Апельсины":
                imageView.setImageResource(R.drawable.orange);
                break;
            case "Бананы":
                imageView.setImageResource(R.drawable.banana);
                break;
        }
    }

    static class CategoryViewHolder extends RecyclerView.ViewHolder { // представляет ViewHolder для элементов списка
        ImageView imageView;
        TextView textView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(String category);
    }
}
