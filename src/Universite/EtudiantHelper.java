package Universite;


/**
* Universite/EtudiantHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Universite.idl
* Tuesday, 17 December 2024 13:09:15 o'clock CET
*/


// Etudiant interface with attributes and methods
abstract public class EtudiantHelper
{
  private static String  _id = "IDL:Universite/Etudiant:1.0";

  public static void insert (org.omg.CORBA.Any a, Universite.Etudiant that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Universite.Etudiant extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Universite.EtudiantHelper.id (), "Etudiant");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Universite.Etudiant read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_EtudiantStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Universite.Etudiant value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Universite.Etudiant narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Universite.Etudiant)
      return (Universite.Etudiant)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Universite._EtudiantStub stub = new Universite._EtudiantStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Universite.Etudiant unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Universite.Etudiant)
      return (Universite.Etudiant)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Universite._EtudiantStub stub = new Universite._EtudiantStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}