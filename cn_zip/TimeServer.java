import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class TimeClient {
  public static void main(String args[]) throws IOException {
    ServerSocket servSocket = null;

    try {
      servSocket = new ServerSocket(1313);
    } catch (IOException e) {
      System.err.println("Couldnot listen on port");
      System.exit(1);
    }
    Socket clntSock = null;
    for (;;) {
      try {
        clntSock = servSocket.accept();
      } catch (IOException e) {
        System.err.println("Accept failed");
        System.exit(1);
      }
      ObjectOutputStream timeOut = new ObjectOutputStream(clntSock.getOutputStream());
      timeOut.writeObject(new Date());
      timeOut.close();
      clntSock.close();
      // servSocket.close();
    }

  }
}