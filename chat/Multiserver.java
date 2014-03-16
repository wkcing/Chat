package chat;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Multiserver extends Thread {

    int puerto;
    File clientdata = new File("clientdata");
    //constructor con puerto por defecto.

    public Multiserver() {
        puerto = 8080;
    }
    //constructor con asignacion de atributo puerto.

    public Multiserver(int puerto) {
        this.puerto = puerto;
    }

    public Multiserver(int puerto, File clientdata) {
        this.puerto = puerto;
        this.clientdata = clientdata;
    }

    public void probar() throws Exception {
        ServerSocket serverSocket = new ServerSocket(puerto);
        serverSocket.close();
    }

    @Override
    public void run() {
        //acepta conexiones con un socket servidor y lo pasa a un hilo (server)
        //nuevo para cada una segun van llegando.
        try (ServerSocket serverSocket = new ServerSocket(puerto)) {

            System.out.println("Esperando clientes en el puerto " + puerto + "...");
            while (true) {
                new Server(serverSocket.accept(), clientdata).start();
            }
            //try-catch obligatorio por excepcion si no puede aceptar la conexion.
        } catch (Exception e) {
            System.err.println("error al aceptar conexion nueva (puerto " + puerto + " inaccesible?)");
            System.exit(1);
        }
    }
}
