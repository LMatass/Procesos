package PSP_U3EX01.EJ4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ProgramaB {
    public static void main(String[] args) throws IOException {
        // Creamos el socket
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
        // Creamos el paquete Datagram para recibir el mensaje
        DatagramPacket dp = new DatagramPacket(buf, 1024);
        InetAddress ip = InetAddress.getByName("127.0.0.1");

        boolean flag = true;
        // bucle que espera a la llegada del mensaje "token"
        while (flag) {
            // Se recibe el mensaje
            ds.receive(dp);
            // Se encapsula el mensaje recibido en una variable.
            String messageReceived = new String(dp.getData(), 0, dp.getLength());
            // Si el mensaje recibido es "token" se envia un paquete con el mensaje "rebut"
            if (messageReceived.equals("token")) {
                String strAnswer = "rebut";
                DatagramPacket dpAnswer = new DatagramPacket(strAnswer.getBytes(), strAnswer.length(), ip, 3001);
                ds.send(dpAnswer);
                flag = false;
            }
        }
        ds.close();
    }
}
