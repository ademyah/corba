package Universite;

import Universite.PromotionPOA;
import Universite.Etudiant;
import Universite.EtudiantHelper; // Import the generated helper
import Universite.EtudiantImpl;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;

import java.util.HashMap;

public class PromotionImpl extends PromotionPOA {
    private HashMap<Integer, Etudiant> etudiants = new HashMap<>();  // Store CORBA references
    private POA poa;  // Keep reference to the POA

    public PromotionImpl(POA poa) {
        this.poa = poa;  // Associate the POA with the servant
    }

    @Override
    public void ajouter_un_etudiant(String nom, String prenom, int numEtudiant) {
        try {
            // Create the servant object (EtudiantImpl)
            EtudiantImpl etudiantImpl = new EtudiantImpl(nom, prenom, numEtudiant);

            // Activate the servant and obtain a CORBA reference
            org.omg.CORBA.Object ref = poa.servant_to_reference(etudiantImpl);

            // Narrow the CORBA reference to the Etudiant interface
            Etudiant etudiantReference = EtudiantHelper.narrow(ref);

            // Store the narrowed CORBA reference in the map
            etudiants.put(numEtudiant, etudiantReference);
            System.out.println("Student added: " + nom + " " + prenom + " with ID " + numEtudiant);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Etudiant rechercher_un_etudiant(int numEtudiant) {
        System.out.println("Searching for student with ID: " + numEtudiant);
        Etudiant etudiant = etudiants.get(numEtudiant);
        if (etudiant == null) {
            System.out.println("Student with ID " + numEtudiant + " not found!");
        }
        return etudiant;
    }

    @Override
    public float calculer_moyenne_de_la_promotion() {
        float totalMoyenne = 0;
        int count = 0;
        for (Etudiant etudiant : etudiants.values()) {
            totalMoyenne += etudiant.Calculer_la_moyenne();
            count++;
        }
        return count == 0 ? 0 : totalMoyenne / count;
    }
}
