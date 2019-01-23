package cmpt431.assignment1;

import java.rmi.*;
import java.rmi.server.*;
import java.util.Date;

public class clockImpl extends UnicastRemoteObject implements clockInterface {

    // Default constructor to throw RemoteException from its parent constructor
    clockImpl() throws RemoteException {
        super();
    }

    // Implementation of the query interface
    public Date getServerTime() throws RemoteException {
        // sends a date object as a response
        return (new Date());
    }
}
