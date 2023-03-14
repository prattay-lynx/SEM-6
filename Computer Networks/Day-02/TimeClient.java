import java.net.*;
import java.io.*;
import java.util.Date;

public class TimeClient {
  public static void main(String args[]) throws IOException {
    Socket timeSocket = null;
    ObjectInputStream timeIn = null;
    try {
      timeSocket = new Socket("127.0.0.1", 1313);
      timeIn = new ObjectInputStream(timeSocket.getInputStream());

    } catch (UnknownHostException e) {
      System.err.println("Server 'localhost' is unknown ");
      System.exit(1);
    } catch (IOException e) {
      System.err.println("Error during connection to 'localhost'");
      System.exit(1);
    }
    try {
      Date serverDate = (Date) timeIn.readObject();
      System.out.println("Current Server time : " + serverDate);
    } catch (ClassNotFoundException e) {
      System.err.println("Not a date object returned");
      System.exit(1);
    }
    timeIn.close();
    timeSocket.close();
  }
}
