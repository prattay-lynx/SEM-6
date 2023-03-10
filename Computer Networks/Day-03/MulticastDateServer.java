import java.io.*;
import java.net.*;
import java.util.Date;
public class MulticastDateServer{
    public static void main(String[] args) throws IOException,InterruptedException{
        DatagramSocket socket = new DatagramSocket(5175);   //use DatagramSocket class in case of connectionless socket
        for(int i=0;i<50;i++)
        {
            byte[] buf = new Date().toString().getBytes();
            InetAddress group = InetAddress.getByName("235.12.36.11");
            DatagramPacket packet = new DatagramPacket(buf,buf.length,group,1913);
            socket.send(packet);
            Thread.sleep(1500);

        }
        socket.close();
    }
}