// client
package cmpt431.assignment1;

import java.rmi.*;
import java.lang.*;
import java.io.*;
import java.util.*;
import java.time.*;

public class clockClient {
    public static void main(String args[]) {
        try {
            // start timer before sending request
            long startTimer = java.time.Instant.now().getEpochSecond();



            // lookup method to find reference of remote object
            Instant serverTime = ((clockInterface) Naming.lookup("rmi://localhost:1900/cmpt431")).getServerTime();

            // end timer after getting the response
            long endTimer = java.time.Instant.now().getEpochSecond();



            // compute RTT in ms
            long rtt = endTimer - startTimer;

            // compute client's time i.e. tc = ts + dsc
            long clientTime = serverTime.getEpochSecond() + (rtt/2);
             System.out.println("Client time without rtt: " + serverTime.getEpochSecond());
             System.out.println("rtt: " + rtt);
             System.out.println("rtt/2: " + rtt/2);
             System.out.println("Client time with rtt: " + clientTime);
            // set client time

            // creating list of commands  
            List<String> commands = new ArrayList<String>();
            //commands.add(String.format("date -r %s", clientTime)); // command 
            commands.add("date");
            commands.add("-r");
            commands.add(""+clientTime);

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

            System.out.println("Server time: " + serverTime.getEpochSecond());
        } catch(Exception e) {
            System.out.println("Client exception: " + e.toString());
        }
    }
}
