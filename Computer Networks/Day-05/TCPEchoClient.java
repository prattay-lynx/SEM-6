// Implementation of Echo service
// 1) Server IP
// 2) Message
// 3) Port Number

// IANA: Internet Assigned Numbers Authority
// -----------------------------------------
// CLIENT CODE:

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TCPEchoClient {
    public static void main(String[] args) throws IOException {
        if ((args.length < 2) || (args.length > 3))
            throw new IllegalArgumentException("Parameter(s): <server> <word> [<port>]"); // 3rd bracket means port
                                                                                          // number is optional
        String server = args[0];
        byte[] byteBuffer = args[1].getBytes();
        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;
        Socket sock = new Socket(server, servPort);
        System.out.println("Connected to server...sending echo string");
        InputStream in = sock.getInputStream();
        OutputStream out = sock.getOutputStream();
        out.write(byteBuffer);
        int totalBytesRevd = 0;
        int bytesRevd;
        while (totalBytesRevd < byteBuffer.length) {
            if ((bytesRevd = in.read(byteBuffer, totalBytesRevd, byteBuffer.length - totalBytesRevd)) == -1)
                throw new SocketException("Connection closed permanently");
            totalBytesRevd += bytesRevd;
        }
        System.out.println("Received: " + new String(byteBuffer));
        sock.close();
    }
}

/*
 * javac TCPEchoClient.java
 * java TCPEchoClient 127.0.0.1 prattay 8080 // if port no. is not given then it
 * will run on speciaaly assigned port no 7
 * or
 * java TCPEchoClient 172.16.1.30 prattay 8081 // Run the server on different
 * machine
 */