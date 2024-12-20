package Universite;


/**
* Universite/EtudiantPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Universite.idl
* Tuesday, 17 December 2024 13:09:15 o'clock CET
*/


// Etudiant interface with attributes and methods
public abstract class EtudiantPOA extends org.omg.PortableServer.Servant
 implements Universite.EtudiantOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_nom", new java.lang.Integer (0));
    _methods.put ("_get_prenom", new java.lang.Integer (1));
    _methods.put ("_get_numeroEtudiant", new java.lang.Integer (2));
    _methods.put ("Ajouter_une_epreuve", new java.lang.Integer (3));
    _methods.put ("Liste_des_epreuves", new java.lang.Integer (4));
    _methods.put ("Calculer_la_moyenne", new java.lang.Integer (5));
    _methods.put ("Emprunter_un_livre", new java.lang.Integer (6));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {

  // Attributes
       case 0:  // Universite/Etudiant/_get_nom
       {
         String $result = null;
         $result = this.nom ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // Universite/Etudiant/_get_prenom
       {
         String $result = null;
         $result = this.prenom ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // Universite/Etudiant/_get_numeroEtudiant
       {
         int $result = (int)0;
         $result = this.numeroEtudiant ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }


  // Methods
       case 3:  // Universite/Etudiant/Ajouter_une_epreuve
       {
         Universite.Epreuve epreuve = Universite.EpreuveHelper.read (in);
         this.Ajouter_une_epreuve (epreuve);
         out = $rh.createReply();
         break;
       }

       case 4:  // Universite/Etudiant/Liste_des_epreuves
       {
         String $result[] = null;
         $result = this.Liste_des_epreuves ();
         out = $rh.createReply();
         Universite.StringListHelper.write (out, $result);
         break;
       }


  // Use the typedef here
       case 5:  // Universite/Etudiant/Calculer_la_moyenne
       {
         float $result = (float)0;
         $result = this.Calculer_la_moyenne ();
         out = $rh.createReply();
         out.write_float ($result);
         break;
       }

       case 6:  // Universite/Etudiant/Emprunter_un_livre
       {
         Universite.Book livre = Universite.BookHelper.read (in);
         this.Emprunter_un_livre (livre);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Universite/Etudiant:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public Etudiant _this() 
  {
    return EtudiantHelper.narrow(
    super._this_object());
  }

  public Etudiant _this(org.omg.CORBA.ORB orb) 
  {
    return EtudiantHelper.narrow(
    super._this_object(orb));
  }


} // class EtudiantPOA
