package PSP_U3EX01.EJ1;

import PSP_U3EX01.Servidor;

import java.io.IOException;

/*
 Enunciado:
        Escriu una parella de programes (A i B) que transfereixin un fitxer entre
        ells. El programa A haurà de llegir un fitxer de text del disc i enviar-lo a B. B
        rebrà el contingut del fitxer i l&#39;imprimirà per la seva sortida estàndard.
        Utilitza per a això sockets stream.
*/
public class programaB {
    public static void main(String[] args) throws IOException {
        Servidor serv = new Servidor(); //Se crea el servidor

        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
        serv.readFromClient();
        serv.closeServer();
    }
}
