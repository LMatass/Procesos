package PSP_U3EX01.EJ1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import PSP_U3EX01.Cliente;
/*
Enunciado:
       Escriu una parella de programes (A i B) que transfereixin un fitxer entre
       ells. El programa A haurà de llegir un fitxer de text del disc i enviar-lo a B. B
       rebrà el contingut del fitxer i l&#39;imprimirà per la seva sortida estàndard.
       Utilitza per a això sockets stream.
*/
public class programaA {
    public static String readText(String path){
        String content = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder stringBuilder = new StringBuilder();
            char[] buffer = new char[10];
            while (reader.read(buffer) != -1) {
                stringBuilder.append(new String(buffer));
                buffer = new char[10];
            }
            reader.close();
            content = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void main(String[] args) throws IOException
    {
        Cliente cli = new Cliente(); //Se crea el cliente
        System.out.println("Iniciando cliente\n");
        String str = readText("src/PSP_U3EX01/resources/exercise1.txt");

        cli.startClient();
        cli.sendToServer(str);
        cli.closeConnection();

    }
}
