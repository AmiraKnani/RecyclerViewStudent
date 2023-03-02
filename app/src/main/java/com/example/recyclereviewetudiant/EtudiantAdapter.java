package com.example.recyclereviewetudiant;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.EtudiantViewHolder>{

    private Context context;
    private List<Etudiant> listeEtudiant;

    public EtudiantAdapter(Context context, List<Etudiant> listeEtudiant) {
        this.context = context;
        this.listeEtudiant = listeEtudiant;
    }

    @NonNull
    @Override
    public EtudiantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem,parent, false);
        EtudiantViewHolder etudiantViewHolder = new EtudiantViewHolder(view);
        return etudiantViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EtudiantViewHolder holder, int position) {
        Etudiant etudiant = listeEtudiant.get(position);
        holder.Matricule.setText(etudiant.getMatricule());
        holder.Nom.setText(etudiant.getNom());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Confirmation supression");
                builder.setMessage("Voulez vous vraiment supprimer défintivement l'étudiant de la matricule :" + listeEtudiant.get(position).getMatricule()+ "de la liste des étudiants");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                      listeEtudiant.remove(position);
                      notifyItemRemoved(position);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listeEtudiant.size();
    }

    public static class EtudiantViewHolder extends RecyclerView.ViewHolder{
        TextView Matricule;
        TextView Nom;

        public EtudiantViewHolder(@NonNull View itemView) {
            super(itemView);
            Matricule= itemView.findViewById(R.id.Matricule);
            Nom = itemView.findViewById(R.id.Nom);
        }
    }
}
