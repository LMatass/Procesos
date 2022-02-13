package PSP_U3EX01;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import PSP_U3EX01.Conexion;

public class Servidor extends Conexion //Se hereda de conexión para hacer uso de los sockets y demás
{
    public Servidor() throws IOException{super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando..."); //Esperando conexión

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Petición recibida y aceptada");

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void readFromClient(){
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            while((mensajeServidor = entrada.readLine()) != null) //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido
                System.out.println(mensajeServidor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void answers(){
        switch (mensajeServidor){
            case "Com et dius?" -> System.out.println("Em dic Exercisi 2");
            case "Quantes lineas de codi tens?" -> System.out.println("Tenc 80 lineas de codi");
            case "Otra" -> System.out.println("No he entes la pregunta");
        }
    }

    public void closeServer(){
        try {
            ss.close();//Se finaliza la conexión con el cliente
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}