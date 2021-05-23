package com.example.recicleviewcolor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import java.util.TreeMap;

public class ColorAdapter extends ListAdapter<TreeMap<Integer, String>, ColorViewHolder> {
    LayoutInflater inflater;

    protected ColorAdapter(LayoutInflater inflater) {
        super(DIFF_CALLBACK); // задаём специальный объект-сравниватель
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ColorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // создать View с разметкой
        View item = inflater.inflate(R.layout.item, parent, false);
        return new ColorViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ColorViewHolder holder, int position) {
        // привязать данные
        holder.bindTo(getItem(position));
    }

    // объект сравнивает два элемента списка: буквально и по содержанию
    static final DiffUtil.ItemCallback<TreeMap<Integer, String>> DIFF_CALLBACK = new DiffUtil.ItemCallback<TreeMap<Integer, String>>() {
        @Override
        public boolean areItemsTheSame(@NonNull TreeMap<Integer, String> oldItem, @NonNull TreeMap<Integer, String> newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull TreeMap<Integer, String> oldItem, @NonNull TreeMap<Integer, String> newItem) {
            return areItemsTheSame(oldItem, newItem);
        }
    };

}

