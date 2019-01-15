package cmpt431.A2I;

// Java program to implement the Search interface
import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class clockImpl extends UnicastRemoteObject implements clock {

    // Default constructor to throw RemoteException
    // from its parent constructor
    clockImpl() throws RemoteException
    {
        super();
    }
    // Implementation of the query interface
    public String time(String time)
            throws RemoteException
    {
        String result;
        // Instantiate a Date object
        Date date = new Date();
        if (time.equals("Time on server"))
            result = String.format("Current Date/Time : %tc", date );
        else
            result = "Not Found";

        return result;
    }
}

