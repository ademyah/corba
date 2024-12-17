package Universite;


import Universite.EtudiantPOA;
import Universite.Epreuve;
import Universite.Book;
import java.util.ArrayList;

public class EtudiantImpl extends EtudiantPOA {
    private String nom;
    private String prenom;
    private int numeroEtudiant;  // Changed to int to match generated code
    private ArrayList<Epreuve> epreuves = new ArrayList<>();
    private ArrayList<Book> livresEmpruntes = new ArrayList<>();

    // Constructor
    public EtudiantImpl(String nom, String prenom, int numeroEtudiant) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroEtudiant = numeroEtudiant;
    }

    @Override
    public String nom() {
        return nom;
    }

    @Override
    public String prenom() {
        return prenom;
    }

    @Override
    public int numeroEtudiant() {
        return numeroEtudiant;
    }

    @Override
    public void Ajouter_une_epreuve(Epreuve epreuve) {
        epreuves.add(epreuve);
    }

    @Override
    public String[] Liste_des_epreuves() {
        ArrayList<String> noms = new ArrayList<>();
        for (Epreuve e : epreuves) {
            noms.add(e.nomEpreuve);
        }
        return noms.toArray(new String[0]);
    }

    @Override
    public float Calculer_la_moyenne() {
        float somme = 0;
        float totalCoefficients = 0;
        for (Epreuve e : epreuves) {
            somme += e.note * e.coefficient;
            totalCoefficients += e.coefficient;
        }
        return totalCoefficients == 0 ? 0 : somme / totalCoefficients;
    }

    @Override
    public void Emprunter_un_livre(Book livre) {
        livresEmpruntes.add(livre);
    }
}
