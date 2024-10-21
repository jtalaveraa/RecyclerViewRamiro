package com.example.recyclerviewclase.adapter;


import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewclase.R;
import com.example.recyclerviewclase.modelos.Dinosaurio;

import java.util.List;

import com.example.recyclerviewclase.DetalleDinosaurio;

public class DinosariosAdapter extends RecyclerView.Adapter<DinosariosAdapter.DinosaurioViewHolder> {

    private List<Dinosaurio> dinasauriosLista; // Se crea la lista de tipo Dinosaurio

    public DinosariosAdapter(List<Dinosaurio> dinasauriosLista) {
        this.dinasauriosLista = dinasauriosLista;
    }


    @NonNull
    @Override
    public DinosariosAdapter.DinosaurioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext()); // Convertir XML a vista con el metodo de inflar
        View view = inflater.inflate(R.layout.itemdino,parent, false);

        return new DinosaurioViewHolder(view); // Regresar vista al metodo de view holder
    }




    @Override
    public void onBindViewHolder(@NonNull DinosariosAdapter.DinosaurioViewHolder holder, int position) {
        holder.setData(dinasauriosLista.get(position));
    }

    @Override
    public int getItemCount() {
        return dinasauriosLista.size(); // Primero se llena este metodo y es el tamaño de la vista
    }

    public class DinosaurioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{ // Esta clase es un recycler view y un listener
        TextView txtnombre, txttipo, txtdescripcion;
        Dinosaurio dino;
        ImageView imview;
        Color Color;
        public DinosaurioViewHolder(@NonNull View itemView) {
            super(itemView);
            txtnombre = itemView.findViewById(R.id.txtnombre);
            txttipo = itemView.findViewById(R.id.txttipo);
            txtdescripcion = itemView.findViewById(R.id.txtdescripcion);
            imview = itemView.findViewById(R.id.ivimagen);
            imview.setOnClickListener(this);
            /* OTRA FORMA DE IMPLEMENTAR EL setOnClickListener
            imview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }

            }); */
        }

        public void setData(Dinosaurio dinosario){
            dino = dinosario;
            txtnombre.setText(dino.getNombre());
            txttipo.setText(dino.getTipo());
            txtdescripcion.setText(dino.getDescripcion());
            imview.setImageResource(dino.getImagen());
            try {
                itemView.setBackgroundColor(Color.parseColor(dinosario.getColor()));
            } catch (IllegalArgumentException e) {
                itemView.setBackgroundColor(Color.LTGRAY);
            }
        }


        @Override
        public void onClick(View view) {

            Intent intent = new Intent(view.getContext(), DetalleDinosaurio.class);
            intent.putExtra("dinosaurio", dino);


            view.getContext().startActivity(intent); //Saber en que contexto estoy en el recyclerView

        }
    }
}
