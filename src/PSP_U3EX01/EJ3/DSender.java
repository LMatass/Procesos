package PSP_U3EX01.EJ3;

import java.net.*;
public class DSender{
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String str = "Uep";
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
        ds.send(dp);

        ds.setSoTimeout(2000);

        DatagramSocket ds_receive = new DatagramSocket(3001);
        byte[] buf = new byte[1024];
        DatagramPacket dp_receive = new DatagramPacket(buf, 1024);

        ds_receive.receive(dp_receive);
        String response = new String(dp_receive.getData(), 0, dp_receive.getLength());
        System.out.println(response);

        ds_receive.close();

        ds.close();



    }
}