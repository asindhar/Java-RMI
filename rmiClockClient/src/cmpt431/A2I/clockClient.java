package cmpt431.A2I;

//program for client application
import java.rmi.*;

public class clockClient
{
    public static void main(String args[])
    {
        String answer,value="Time on server";
        try
        {
            // lookup method to find reference of remote object
            clock access =
                    (clock) Naming.lookup("rmi://localhost:1900"+
                            "/cmpt431");
            answer = access.time(value);
            System.out.println(" '" + value +
                    "' " + answer+".... ;) ");
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}
