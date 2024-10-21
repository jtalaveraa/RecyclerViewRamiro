package com.example.recyclerviewclase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.example.recyclerviewclase.modelos.Dinosaurio;


public class DetalleDinosaurio extends AppCompatActivity {
    TextView txtNombre, txtDescripcion;
    ImageView imagen;
    Color color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_dinosaurio);
        Intent intent = getIntent();
            intent.getSerializableExtra("dinosaurio");
        Dinosaurio dino = (Dinosaurio) intent.getSerializableExtra("dinosaurio");
        txtNombre = findViewById(R.id.txtnombred);
        txtDescripcion = findViewById(R.id.txtdescripciond);
        imagen = findViewById(R.id.ivimagen);
        ConstraintLayout layout = findViewById(R.id.main);


        if (dino != null) {
            txtNombre.setText(dino.getNombre());
            txtDescripcion.setText(dino.getDescripcion());
            imagen.setImageResource(dino.getImagen());
            layout.setBackgroundColor(Color.parseColor(dino.getColor()));
        }
    }
}