package chat;

import java.net.*;
import javax.swing.JTextArea;

public class Visor extends Thread {

    int puerto;
    JTextArea txtvisor = null;
    MulticastSocket mcsocket;
    InetAddress grupo;
    String detodos;
    
    //constructor por defecto.

    public Visor() {
        super("Visor");
        puerto = 8080;
    }

    //constructor con asignacion de puerto
    public Visor(int puerto) {
        super("Visor");
        this.puerto = puerto;
    }
    //constructor con referencia a txtvisor en GUI.

    public Visor(int puerto, JTextArea txtvisor) {
        super("Visor");
        this.puerto = puerto;
        this.txtvisor = txtvisor;
    }

    //abre un nuevo multicast socket para recibir de los server.
    // y lo adjunta al grupo asociado a la ip reservada (Clase D, para
    //multicast).
    public void configurar() {
        try {
            mcsocket = new MulticastSocket(puerto);
            grupo = InetAddress.getByName("224.0.0.1");
            mcsocket.joinGroup(grupo);
        } catch (Exception e) {
            System.err.println("error al configurar visor.");
            System.exit(1);
        }
    }
    //recibe por el socket multicast y actualiza detodos

    private void recibir() {

        byte[] dgbuf = new byte[256];
        //Crea un paquete DatagramPacket, que es el formato de
        //comunicacion por multicast.
        DatagramPacket dgpacket = new DatagramPacket(dgbuf, dgbuf.length);
        try {
            mcsocket.receive(dgpacket);
            //traduce del formato DatagramPacket a string.
            detodos = new String(dgpacket.getData());
            //recorta el exceso de espacios en blanco del buffer (no tiene
            //porque ocupar los 256).
            detodos = detodos.trim();

        } catch (Exception e) {
            System.err.println("error al recibir datos.");
            System.exit(1);
        }

    }

    private void imprimir() {
        while (true){
        recibir();
        //imprime lo recibido por pantalla
        System.out.println(detodos);
        //envia a GUI
        if (txtvisor != null) {
            txtvisor.append("\n" + detodos);
        }           
        }
 
    }

    @Override
    public void run() {
        configurar();
        System.out.println("Puerto: " + puerto);
        imprimir();
    }
}
