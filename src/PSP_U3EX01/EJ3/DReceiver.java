package PSP_U3EX01.EJ3;

import java.net.*;

/*
Enunciado
    Escriu un programa que respongui a salutacions utilitzant sockets
    Datagram. El programa escoltarà pel sòcol, missatges que continguin la
    cadena de text &quot;Uep&quot;. Quan en rebi un, respondrà al seu emissor amb un
    altre missatge que contingui la cadena &quot;Què tal?&quot;. Escriu a més un
    programa addicional per provar el funcionament d&#39;aquest.
 */
public class DReceiver{
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(3000);
        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, 1024);

        ds.receive(dp);
        String messageReceived = new String(dp.getData(), 0, dp.getLength());

        InetAddress ip = InetAddress.getByName("127.0.0.1");
        String strAnswer = "Que tal?";
        DatagramPacket dpAnswer = new DatagramPacket(strAnswer.getBytes(), strAnswer.length(), ip, 3001);

        if (messageReceived.equals("Uep")){
            ds.send(dpAnswer);
            System.out.println(messageReceived);
        }


        ds.close();
    }
}
