package Universite;


/**
* Universite/EtudiantOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Universite.idl
* Tuesday, 17 December 2024 13:09:15 o'clock CET
*/


// Etudiant interface with attributes and methods
public interface EtudiantOperations 
{

  // Attributes
  String nom ();
  String prenom ();
  int numeroEtudiant ();

  // Methods
  void Ajouter_une_epreuve (Universite.Epreuve epreuve);
  String[] Liste_des_epreuves ();

  // Use the typedef here
  float Calculer_la_moyenne ();
  void Emprunter_un_livre (Universite.Book livre);
} // interface EtudiantOperations
