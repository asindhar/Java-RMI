package cmpt431.A2I;

//program for server application
import java.rmi.*;
import java.rmi.registry.*;

public class clockServer
{
    public static void main(String args[])
    {
        try
        {
            // Create an object of the interface
            // implementation class
            clock obj = new clockImpl();

            // rmiregistry within the server JVM with
            // port number 1900
            LocateRegistry.createRegistry(1900);

            // Binds the remote object by the name
            // cmpt431
            Naming.rebind("rmi://localhost:1900"+
                    "/cmpt431",obj);
            System.out.println("Server is ready to use...");
        }
        catch(Exception ae)
        {
            System.out.println("Exception occurred in server\n");
            System.out.println(ae);
        }
    }
}

