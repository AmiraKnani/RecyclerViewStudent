package com.example.recyclereviewetudiant;

public class Etudiant implements Comparable<Etudiant>{
    private String matricule;
    private String nom;

    public Etudiant(String matricule, String nom) {
        this.matricule = matricule;
        this.nom = nom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public int compareTo(Etudiant etudiant) {
        return this.matricule.compareTo(etudiant.matricule);
    }
}
