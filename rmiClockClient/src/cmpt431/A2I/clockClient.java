// client
package cmpt431.assignment1;

import java.rmi.*;
import java.lang.*;
import java.io.*;
import java.util.*;

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
            long clientTime = serverTime.getTime() + (rtt/2);

            // set client time

            // creating list of commands  
            List<String> commands = new ArrayList<String>();
            commands.add(String.format("date -r %s", clientTime)); // command 

            // creating the process 
            ProcessBuilder pb = new ProcessBuilder(commands); 
            
            // starting the process 
            Process process = pb.start(); 
            
            // for reading the ouput from stream 
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream())); 
            String s = null; 
            while ((s = stdInput.readLine()) != null) 
            { 
                System.out.println(s); 
            } 

            System.out.println("Server time: " + serverTime.getTime());
        } catch(Exception e) {
            System.out.println("Client exception: " + e.toString());
        }
    }
}
