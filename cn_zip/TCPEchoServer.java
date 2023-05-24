//SERVER CODE:

import java.io.*;
import java.net.*;

public class TCPEchoServer {
    private static final int BUFSIZE = 80;

    public static void main(String[] args) throws IOException {
        if (args.length != 1)
            throw new IllegalArgumentException("Parameter(s): <Port>");
        int servPort = Integer.parseInt(args[0]);
        ServerSocket servSock = new ServerSocket(servPort);
        int recvMsgSize;
        byte[] byteBuffer = new byte[BUFSIZE];
        for (;;) {
            Socket clntSock = servSock.accept();
            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();
            while ((recvMsgSize = in.read(byteBuffer)) != -1)
                out.write(byteBuffer, 0, recvMsgSize);
            clntSock.close();
        }
    }
}