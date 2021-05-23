package com.example.recicleviewcolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    RecyclerView rview;

    Integer [] colors_res = {R.color.purple, R.color.light_purple, R.color.dark_pink, R.color.pink,
            R.color.light_pink, R.color.dark_orange, R.color.orange, R.color.yellow};
    String[] color_names = {"purple","light_purple", "dark_pink", "pink", "light_pink", "dark_orange", "orange", "yellow"};
    List<TreeMap<Integer, String>> color_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color_list = new ArrayList<>();
        for (int i=0; i< colors_res.length; i++){
            TreeMap<Integer, String> colors = new TreeMap<>();
            int c = ContextCompat.getColor(this, colors_res[i]);
            colors.put(c, color_names[i]);
            color_list.add(colors);
        }
        rview = findViewById(R.id.rview);
        ColorAdapter adapter = new ColorAdapter(getLayoutInflater());
        adapter.submitList(color_list);
        rview.setLayoutManager(new LinearLayoutManager(this));
        // задаём оформление
        rview.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rview.setAdapter(adapter);

    }
}