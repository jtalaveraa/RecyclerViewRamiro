package com.example.recyclerviewclase;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewclase.adapter.DinosariosAdapter;
import com.example.recyclerviewclase.modelos.Dinosaurio;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerDino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerDino=findViewById(R.id.recyclerDino);
        List<Dinosaurio> dinosauriosLista=new ArrayList<>();

        dinosauriosLista.add(new Dinosaurio("T-Rex", "Carnivoro", "Es un dinosaurio muy comelon", "Verde", R.drawable.rex));


        DinosariosAdapter adapter = new DinosariosAdapter(dinosauriosLista);
        recyclerDino.setAdapter(adapter);
        recyclerDino.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerDino.setHasFixedSize(true);
    }
}