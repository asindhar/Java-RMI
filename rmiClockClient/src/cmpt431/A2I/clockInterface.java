package cmpt431.assignment1;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.time.Instant;

public interface clockInterface extends Remote {
    // Declaring the method prototype
    public Instant getServerTime() throws RemoteException;
}