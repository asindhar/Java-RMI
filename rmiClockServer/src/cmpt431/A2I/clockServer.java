// server
package cmpt431.assignment1;

import java.rmi.*;
import java.rmi.registry.*;

public class clockServer {
    public static void main(String args[]) {
        try {
            // Create an object of the interface implementation class
            clockInterface obj = new clockImpl();

            // rmiregistry within the server JVM with port number 1900
            LocateRegistry.createRegistry(1900);

            // Binds the remote object by the name cmpt431
            Naming.rebind("rmi://localhost:1900/cmpt431",obj);

            System.out.println("Listening on port 1900..");
        } catch(Exception e) {
            System.out.println("Server exception: " + e.toString());
        }
    }
}

