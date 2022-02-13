package PSP_U3EX01.EJ5;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Cliente_05 {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Creamos el socket
        Socket socket = new Socket("localhost", 3000);

        // Creamos en inputStream, encargado de recibir los datos del servidor
        InputStream dataInputStream = socket.getInputStream();

        // Esperamos hasta que el dataInputStream este disponible
        int attempts = 0;
        while(dataInputStream.available() == 0 && attempts < 1000)
        {
            attempts++;
            Thread.sleep(10);
        }

        byte[] buffer = new byte[dataInputStream.available()];
        // Lectura del mensaje del servidor
        dataInputStream.read(buffer);
        // Se muestra por pantalla el mensaje
        System.out.println(new String(buffer));

        socket.close();
    }
}
