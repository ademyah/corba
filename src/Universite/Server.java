package Universite;

import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextExtPackage.*;

public class Server {
    public static void main(String[] args) {
        try {
            // Initialize ORB with a hardcoded port for the naming service
            ORB orb = ORB.init(new String[]{"-ORBInitialPort", "1050"}, null);

            // Get reference to RootPOA and activate the POAManager
            org.omg.PortableServer.POA rootpoa = org.omg.PortableServer.POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            // Create servant object
            PromotionImpl promotionImpl = new PromotionImpl(rootpoa);

            // Get the object reference
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(promotionImpl);
            Promotion href = PromotionHelper.narrow(ref);

            // Bind the object to the naming service
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            NameComponent[] path = ncRef.to_name("Promotion");
            ncRef.rebind(path, href);

            System.out.println("Server ready...");
            orb.run();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
