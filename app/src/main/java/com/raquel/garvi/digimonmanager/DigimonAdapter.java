package com.raquel.garvi.digimonmanager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DigimonAdapter extends RecyclerView.Adapter<DigimonAdapter.DigimonViewHolder> {

    private ArrayList<Digimon> digimonList;

    public DigimonAdapter(ArrayList<Digimon> digimonList) {
        this.digimonList = digimonList;
    }

    @NonNull
    @Override
    public DigimonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_digimon, parent, false);
        return new DigimonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DigimonViewHolder holder, int position) {
        Digimon digimon = digimonList.get(position);
        holder.txtName.setText(digimon.getName());
        holder.txtType.setText(digimon.getType());
        holder.txtLevel.setText("Nivel: " + digimon.getLevel());
    }

    @Override
    public int getItemCount() {
        return digimonList.size();
    }

    public void removeItem(int position) {
        digimonList.remove(position);
        notifyItemRemoved(position);
    }

    public Digimon getItemAt(int position) {
        return digimonList.get(position);
    }

    public static class DigimonViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtType, txtLevel;

        public DigimonViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtType = itemView.findViewById(R.id.txtType);
            txtLevel = itemView.findViewById(R.id.txtLevel);
        }
    }



}
