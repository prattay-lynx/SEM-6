import java.net.*;

class CN1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress test = InetAddress.getLocalHost();
        System.out.println("The Ip address is:" + test);
        InetAddress test1 = InetAddress.getByName("www.geeksforgeeks.com");
        System.out.println("Ip adress of the website:" + test1);

    }
}
/*
 * output:The Ip address is:C1-31/172.16.1.31
 * Ip adress of the website:www.geeksforgeeks.com/199.59.243.222
 */