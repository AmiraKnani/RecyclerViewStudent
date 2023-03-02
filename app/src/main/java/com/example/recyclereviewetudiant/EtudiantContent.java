package com.example.recyclereviewetudiant;

import java.sql.Array;
import java.util.ArrayList;

public class EtudiantContent {
    public static ArrayList<Etudiant> getEtudiants()
    {
        ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        etudiants.add(new Etudiant("199","Amira"));
        etudiants.add(new Etudiant("019","Salma"));
        etudiants.add(new Etudiant("001","Neziha"));
        return etudiants;
    }

}
