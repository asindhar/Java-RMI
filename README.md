# cmpt431 Assignment 1

## Summary:

A very basic two-way Client and Server setup where a Client requests server time and the server sends a `Date` object to the client. Client uses this `Date` object to extract time by invoking `getTime()` method on this `Date` object. After computing RTT client sets its system time to server time plus the half of RTT.

## Computing RTT:

We start a timer using java `Date` object on the client side and stop this timer once we get the response back from the server. Since RMI is blocking in nature this is a good way of computing RTT.

## Chaning client's time:

To set the client time we used a java class `ProcessBuilder` to create an operating system process. This process runs a bash command on the client i.e. `sudo date ${CLIENT_NEW_TIME}`. _NOTE: This command will only work for unix based OS on both server and client side_.

## Running server and client:

1. compile server `javac -d . clockInterface.java clockImpl.java clockServer.java`
2. compile client `javac -d . clockInterface.java clockClient.java`
3. start server `java cmpt431.assignment1.clockServer`
4. start client `java cmpt431.assignment1.clockClient`
