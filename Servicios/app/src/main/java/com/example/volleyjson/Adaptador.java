package com.example.volleyjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyViewHolder> {

    private Context mContexto;
    private List<Pokemon> mDatos;

    public Adaptador(Context mContexto, List<Pokemon> mDatos){
        this.mContexto = mContexto;
        this.mDatos = mDatos;
    }

    @NonNull
    @Override //Metodo necesario para la RecyclerView
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return null;
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContexto);
        v = inflater.inflate(R.layout.pokemon_indivudual, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pokemon p = mDatos.get(position);

        holder.url.setText(mDatos.get(position).getUrl());
        holder.name.setText(mDatos.get(position).getName());

        Glide.with(mContexto)
                //.load(mDatos.get(position).getImg())
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + p.getNumber() + ".png")
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return mDatos.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView url;
        ImageView img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_txt);
            url = itemView.findViewById(R.id.id_txt);//le ponemos a la id lo del text view en el layout para pelicula_individual
            img = itemView.findViewById(R.id.imageView);
        }
    }

}
