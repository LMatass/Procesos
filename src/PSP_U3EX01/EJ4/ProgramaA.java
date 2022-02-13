package PSP_U3EX01.EJ4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/*
Enunciado
    Escriu una parella de programes (A i B) que usin socket Datagram per
    intercanviar un missatge anomenat “token”. A l&#39;arrencar, el programa A
    enviarà un missatge al B amb la paraula &quot;token&quot;. Quan el B la rebi, enviarà
    de tornada a A un missatge amb la paraula &quot;rebut&quot;, i acabarà. Quan A rebi
    el missatge de B, acabarà també.
 */
public class ProgramaA {
    public static void main(String[] args) throws IOException {
        // Creacion del socket
        DatagramSocket ds = new DatagramSocket();
        String message = "token";
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        // Enviamos mensaje "token" por el puerto 3000
        DatagramPacket dp = new DatagramPacket(message.getBytes(), message.length(), ip, 3000);
        ds.send(dp);


        boolean flag = true;
        // Bucle que escucha la llegada el mensaje "rebut", si este llega es mostrado por pantalla
        while (flag){
            DatagramSocket ds_receive = new DatagramSocket(3001);
            byte[] buf = new byte[1024];
            DatagramPacket dp_receive = new DatagramPacket(buf, 1024);

            ds_receive.receive(dp_receive);
            String response = new String(dp_receive.getData(), 0, dp_receive.getLength());
            if (response.equals("rebut")){
                System.out.println(response);
                flag = false;
            }
        }


    }
}
