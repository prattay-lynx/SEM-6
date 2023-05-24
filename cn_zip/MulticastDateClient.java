import java.io.*;
import java.net.*;
// import java.util.Date;

public class MulticastDateClient {
    public static void main(String[] args) throws IOException,InterruptedException{
        MulticastSocket socket = new MulticastSocket(1913);
        InetAddress group = InetAddress.getByName("235.12.36.11");
        socket.joinGroup(group);
        for(int i=0;i<50;i++)
        {
            byte[] buf = new byte[256];
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String received = new String(packet.getData());
            System.out.println("Current Server time: "+received);
        }
        socket.leaveGroup(group);
        socket.close();
    }
}
