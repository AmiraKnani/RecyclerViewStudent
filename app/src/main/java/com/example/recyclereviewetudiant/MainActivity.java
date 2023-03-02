package com.example.recyclereviewetudiant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewEtudiant;
    RecyclerView.LayoutManager layoutManager;
    EtudiantAdapter etudiantAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewEtudiant = findViewById(R.id.rcvetudiants);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewEtudiant.setLayoutManager(layoutManager);
        List<Etudiant> listEtudiant = EtudiantContent.getEtudiants();
        etudiantAdapter = new EtudiantAdapter(this,listEtudiant);
        recyclerViewEtudiant.setAdapter(etudiantAdapter);
        Collections.sort(listEtudiant);

    }


}