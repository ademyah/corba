package Universite;


/**
* Universite/_PromotionStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Universite.idl
* Tuesday, 17 December 2024 13:09:15 o'clock CET
*/


// Promotion interface
public class _PromotionStub extends org.omg.CORBA.portable.ObjectImpl implements Universite.Promotion
{

  public void ajouter_un_etudiant (String nom, String prenom, int numEtudiant)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("ajouter_un_etudiant", true);
                $out.write_string (nom);
                $out.write_string (prenom);
                $out.write_long (numEtudiant);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                ajouter_un_etudiant (nom, prenom, numEtudiant        );
            } finally {
                _releaseReply ($in);
            }
  } // ajouter_un_etudiant


  // Use long here
  public Universite.Etudiant rechercher_un_etudiant (int numEtudiant)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("rechercher_un_etudiant", true);
                $out.write_long (numEtudiant);
                $in = _invoke ($out);
                Universite.Etudiant $result = Universite.EtudiantHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return rechercher_un_etudiant (numEtudiant        );
            } finally {
                _releaseReply ($in);
            }
  } // rechercher_un_etudiant


  // Use long here
  public float calculer_moyenne_de_la_promotion ()
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("calculer_moyenne_de_la_promotion", true);
                $in = _invoke ($out);
                float $result = $in.read_float ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return calculer_moyenne_de_la_promotion (        );
            } finally {
                _releaseReply ($in);
            }
  } // calculer_moyenne_de_la_promotion

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Universite/Promotion:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _PromotionStub