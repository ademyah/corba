package Universite;

import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextExtPackage.*;

public class Client {
    public static void main(String[] args) {
        try {
            // Initialize ORB with a hardcoded port for the naming service
            ORB orb = ORB.init(new String[]{"-ORBInitialPort", "1050"}, null);

            // Get reference to the naming service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            // Use NamingContextExt to narrow the reference
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            // Resolve the Promotion object
            Promotion promotionRef = PromotionHelper.narrow(ncRef.resolve_str("Promotion"));

            // Check if the object is resolved successfully
            if (promotionRef == null) {
                System.out.println("Error: Promotion object could not be resolved!");
                return;
            } else {
                System.out.println("Promotion object resolved successfully.");
            }

            // Add the first student
            // Ajout du premier étudiant avec de nouvelles matières et notes
            promotionRef.ajouter_un_etudiant("Alice", "Johnson", 123);
            Etudiant etudiant1 = promotionRef.rechercher_un_etudiant(123);
            if (etudiant1 != null) {
                System.out.println("Ajout des examens pour Alice Johnson...");
                etudiant1.Ajouter_une_epreuve(new Epreuve("Informatique", 18.5f, 3.0f));  // Nouvelle matière et note
                etudiant1.Ajouter_une_epreuve(new Epreuve("Chimie Organique", 16.0f, 2.0f)); // Nouvelle matière et note
                etudiant1.Ajouter_une_epreuve(new Epreuve("Philosophie", 14.5f, 1.5f));  // Nouvelle matière et note
                System.out.println("Moyenne de Alice Johnson : " + etudiant1.Calculer_la_moyenne());

                // Affichage des examens
                String[] exams = etudiant1.Liste_des_epreuves();
                System.out.println("Examens de Alice Johnson :");
                for (String exam : exams) {
                    System.out.println(" - " + exam);
                }
            }

// Ajout du deuxième étudiant avec de nouvelles matières et notes
            promotionRef.ajouter_un_etudiant("Bob", "Williams", 456);
            Etudiant etudiant2 = promotionRef.rechercher_un_etudiant(456);
            if (etudiant2 != null) {
                System.out.println("Ajout des examens pour Bob Williams...");
                etudiant2.Ajouter_une_epreuve(new Epreuve("Mathématiques Avancées", 17.0f, 2.5f));  // Nouvelle matière et note
                etudiant2.Ajouter_une_epreuve(new Epreuve("Génie Mécanique", 15.5f, 2.0f)); // Nouvelle matière et note
                etudiant2.Ajouter_une_epreuve(new Epreuve("Anglais Technique", 16.0f, 1.5f)); // Nouvelle matière et note
                System.out.println("Moyenne de Bob Williams : " + etudiant2.Calculer_la_moyenne());

                // Affichage des examens
                String[] exams = etudiant2.Liste_des_epreuves();
                System.out.println("Examens de Bob Williams :");
                for (String exam : exams) {
                    System.out.println(" - " + exam);
                }
            }

// Ajout du troisième étudiant avec de nouvelles matières et notes
            promotionRef.ajouter_un_etudiant("Charlie", "Brown", 789);
            Etudiant etudiant3 = promotionRef.rechercher_un_etudiant(789);
            if (etudiant3 != null) {
                System.out.println("Ajout des examens pour Charlie Brown...");
                etudiant3.Ajouter_une_epreuve(new Epreuve("Méthodes Numériques", 12.5f, 2.0f));  // Nouvelle matière et note
                etudiant3.Ajouter_une_epreuve(new Epreuve("Économie", 14.0f, 2.0f)); // Nouvelle matière et note
                etudiant3.Ajouter_une_epreuve(new Epreuve("Linguistique", 13.5f, 1.5f)); // Nouvelle matière et note
                System.out.println("Moyenne de Charlie Brown : " + etudiant3.Calculer_la_moyenne());

                // Affichage des examens
                String[] exams = etudiant3.Liste_des_epreuves();
                System.out.println("Examens de Charlie Brown :");
                for (String exam : exams) {
                    System.out.println(" - " + exam);
                }
            }


            // Calculate and print the promotion average
            System.out.println("Calculating promotion average...");
            float promotionAverage = promotionRef.calculer_moyenne_de_la_promotion();
            System.out.println("Promotion average: " + promotionAverage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
