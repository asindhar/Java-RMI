package cmpt431.assignment1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface clockInterface extends Remote {
    // Declaring the method prototype
    public Date getServerTime() throws RemoteException;
}