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

        dinosauriosLista.add(new Dinosaurio("Tyranosaurus Rex", "Carnivoro", "Es un dinosaurio muy comelon", "#32CD32", R.drawable.trexnew));
        dinosauriosLista.add(new Dinosaurio("Triceratops", "Herbivoro", "Es un dinosaurio muy comelon", "#808000", R.drawable.trice));
        dinosauriosLista.add(new Dinosaurio("Velociraptor", "Carnivoro", "Es un dinosaurio muy comelon", "#228B22", R.drawable.velo));
        dinosauriosLista.add(new Dinosaurio("Brachiosaurus", "Herbívoro", "Es un dinosaurio muy comelon", "#77DD77", R.drawable.brachi));
        dinosauriosLista.add(new Dinosaurio("Stegosaurus", "Herbívoro", "Reconocido por sus grandes placas dorsales y una cola con púas. " , "#50C878", R.drawable.stego));
        dinosauriosLista.add(new Dinosaurio("Spinosaurus", "Carnivoro", "Es un dinosaurio muy comelon", "#2E8B57", R.drawable.spinosau));



        DinosariosAdapter adapter = new DinosariosAdapter(dinosauriosLista);
        recyclerDino.setAdapter(adapter);
        recyclerDino.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerDino.setHasFixedSize(true);
    }
}