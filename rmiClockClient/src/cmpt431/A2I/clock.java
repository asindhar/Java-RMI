package cmpt431.A2I;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface clock extends Remote {
    // Declaring the method prototype
    public String time(String time) throws RemoteException;
}

