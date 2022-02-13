package PSP_U3EX01.EJ2;

import PSP_U3EX01.Cliente;
import PSP_U3EX01.Servidor;
import java.io.IOException;
/*
Enunciado:
    Escriu un programa que contesti a preguntes. El programa crearà un
    socket stream i esperarà connexions. Quan arribi una connexió, llegirà els
    missatges rebuts, byte a byte, fins que trobi el caràcter ASCII &quot;?&quot; (signe de
    final d&#39;interrogació). Quan això passi, construirà una frase amb tots els
    bytes rebuts i contestarà amb un missatge. El contingut del missatge
    dependrà de la frase rebuda:
    - Si la frase és &quot;Com et dius?&quot;, respondrà amb la cadena &quot;Em dic Exercici
    2&quot;.
    - Si la frase és &quot;Quantes línies de codi tens?&quot;, Respondrà amb el nombre
    de línies de codi que tingui.
    - Si la frase és qualsevol altra cosa, respondrà &quot;No he entès la pregunta&quot;.
 */

public class Servidor_02 {
    public static void main(String[] args) throws IOException {
        PSP_U3EX01.Servidor serv = new PSP_U3EX01.Servidor(); //Se crea el servidor
        serv.startServer(); //Se inicia el servidor
        serv.readFromClient();
        serv.answers();
        serv.closeServer();
    }
}
