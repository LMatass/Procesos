package PSP_U3EX01;

import java.io.DataOutputStream;
import java.io.IOException;
import PSP_U3EX01.Conexion;

public class Cliente extends Conexion
{
    public Cliente() throws IOException{super("cliente");} //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try
        {
            //Flujo de datos hacia el servidor
            salidaServidor = new DataOutputStream(cs.getOutputStream());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void sendToServer(String output){
        try {
            salidaServidor.writeUTF(output+ "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void closeConnection(){
        try {
            cs.close();//Fin de la conexión
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}