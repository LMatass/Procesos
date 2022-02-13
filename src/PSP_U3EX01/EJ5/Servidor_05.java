package PSP_U3EX01.EJ5;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor_05 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(3000);
        // Arraylist donde seran guardadas las conexiones
        ArrayList<Socket> connections = new ArrayList<Socket>();
        // Bucle infinito que espera las disitntas llamadas de los clientes
        while (true) {
            // Aceptamos la conexion del cliente
            Socket socket = ss.accept();
            // Añadimos la conexion en un arrayList
            connections.add(socket);
            // Se manda al cliente un string que dice el num de conexiones
            // El cliente es el encargado de mostrarlo por pantalla
            OutputStream os = socket.getOutputStream();
            os.write(String.format("Número de clientes: %d", connections.size()).getBytes());
            os.flush();
        }

    }
}
