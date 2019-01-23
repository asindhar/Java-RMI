// client
package cmpt431.assignment1;

import java.rmi.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class clockClient {
    public static void main(String args[]) {
        try {
            // start timer before sending request
            long startTimer = new Date().getTime();

            // lookup method to find reference of remote object
            Date serverTime = ((clockInterface) Naming.lookup("rmi://localhost:1900/cmpt431")).getServerTime();

            // end timer after getting the response
            long endTimer = new Date().getTime();

            // compute RTT in ms
            long rtt = endTimer - startTimer;

            // compute client's time i.e. tc = ts + dsc
            long clientTime = serverTime.getTime() + (rtt / 2);
            System.out.println("Client time without rtt: " + serverTime.getTime() + " ms");
            System.out.println("rtt: " + rtt + " ms");
            System.out.println("rtt/2: " + rtt / 2 + " ms");
            System.out.println("Client time with rtt: " + clientTime + " ms");

            // format time to month:day:hour:min:year.sec
            DateFormat timeFormat = new SimpleDateFormat("MMDDHHmmyy.ss");
            String formatedTime = timeFormat.format(new Date(clientTime));

            // set client time

            // creating list of commands
            List<String> commands = new ArrayList<String>();
            commands.add("sudo");
            commands.add("date");
            commands.add("" + formatedTime);

            // // creating the process
            ProcessBuilder pb = new ProcessBuilder(commands);

            // // starting the process
            Process process = pb.start();

            System.out.println("Server time " + serverTime);

            // // for reading the ouput from stream
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s = null;
            while ((s = stdInput.readLine()) != null) {
                System.out.println("\nClient's time synced with server: " + s);
            }
        } catch (Exception e) {
            System.out.println("Client exception: " + e.toString());
        }
    }
}
