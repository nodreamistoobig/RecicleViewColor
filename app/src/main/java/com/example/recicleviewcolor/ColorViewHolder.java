package com.example.recicleviewcolor;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;
import java.util.TreeMap;

public class ColorViewHolder extends RecyclerView.ViewHolder {
    TextView tv;
    public ColorViewHolder(@NonNull View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.color);
    }
    void bindTo(TreeMap<Integer,String> color) {
        for(Map.Entry<Integer, String> entry : color.entrySet()) {
            tv.setBackgroundColor(entry.getKey());
            tv.setText(entry.getValue());
        }
    }

}