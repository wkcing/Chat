package chat;

import java.io.*;
import java.net.*;

public class Server extends Thread {

    private Socket socket = null;
    private MulticastSocket mcsocket = null;
    private int puerto;
    private String clientnombre;
    InetAddress grupo;
    BufferedReader in;
    File clientdata = new File("clientdata");

    //Constructor del hilo, abre un nuevo multicastSocket para enviar mensajes
    //a Visor, ademas de asignar el socket dado para conexion con su cliente.
    public Server(Socket socket) {
        super("Server");
        this.socket = socket;
        this.puerto = socket.getLocalPort();
        try {
            this.mcsocket = new MulticastSocket(puerto);
        } catch (Exception e) {
            System.err.println("error");
        }

    }

    public Server(Socket socket, File clientdata) {
        super("Server");
        this.socket = socket;
        this.puerto = socket.getLocalPort();
        this.clientdata= clientdata;
        try {
            this.mcsocket = new MulticastSocket(puerto);
        } catch (Exception e) {
            System.err.println("error");
        }

    }
    //recibe el nombre de usuario de su cliente y lo compara con la base de datos
    //de usuarios y contraseñas: clientdata, en formato texto.

    public void logincliente() {
        try {
            //si no existe base de datos clientdata, crea un archivo vacio.
            clientdata.createNewFile();
            //configura lectura y escritura al archivo clientdata.
            BufferedReader indatos = new BufferedReader(new FileReader(clientdata));
            BufferedWriter outdatos = new BufferedWriter(new FileWriter(clientdata, true));
            //configura un escritor al socket con el cliente.
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            String contra;
            //obtiene el nombre del cliente
            String nombre = in.readLine();

            //comprueba que no sea un string vacio
            if (nombre.length() > 0) {
                //informa al cliente del protocolo de comunicacion a seguir
                //ver Client.loginusuario()
                out.println("usuariodado");
                Boolean usuarioencontrado = false;
                //lee los nombres de usuario de la base de datos
                while (indatos.ready() && !usuarioencontrado) {

                    String usuario = indatos.readLine();
                    //si encuentra el nombre de usuario, pide la contraseña al cliente
                    if (usuario.equals(nombre) && !usuario.startsWith("contra ")) {
                        usuarioencontrado = true;

                        out.println("Usuario " + nombre + " ya existe. Introduzca contrasena: ");
                        contra = "contra " + in.readLine();
                        //comprueba la contraseña dada con la linea siguiente de
                        //la base de datos, que corresponde a la contraseña del
                        //usuario en la linea previa
                        if (indatos.readLine().equals(contra)) {
                            //si es correcta, asigna el nombre de usuario al cliente
                            out.println("Contrasena correcta");
                            clientnombre = nombre;
                        } else {
                            //si no es correcta, mantiene la IP para identificar al cliente.
                            System.out.println("Contrasena incorrecta");
                            out.println("Contrasena incorrecta, usando IP como nombre de usuario");
                        }
                    }
                } //si el usuario no esta en la base de datos, lo registra en ella.
                if (!usuarioencontrado) {
                    out.println("Usuario nuevo. Introduzca su nueva contrasena para registrarse: ");
                    contra = "contra " + in.readLine();
                    //escribe en el archivo el nuevo usuario con su contraseña,
                    //con el formato usuario\ncontra contraseña, y asigna el nombre al cliente.
                    outdatos.newLine();
                    outdatos.append(nombre);
                    outdatos.newLine();
                    outdatos.append(contra);
                    clientnombre = nombre;
                    out.println("Registrado.\n");
                }
                //cierra lectura y escritura del archivo
                indatos.close();
                outdatos.close();
            } else {
                //si el nombre es un string vacio, mantiene la IP para identificar al cliente.
                out.println("usuariovacio");
                out.println("Usuario no dado, usando IP como nombre de usuario.\n");
            }
        } catch (Exception e) {
            System.err.println("error de login");
        }
    }

    //envia el string mensaje a todos los visores via el multicast socket.
    //para ello previamente tienen que convertirlo a un byte array, vector de tipos byte.
    //despues tiene que crear un paquete DatagramPacket que será lo que se envie al grupo
    //definido por la direccion IP reservada (de la Clase D dedicada a multicast),
    //y por el puerto.
    private void enviar(String mensaje) {
        byte[] dgbuf = mensaje.getBytes();
        DatagramPacket dgpaquete = new DatagramPacket(dgbuf, dgbuf.length, grupo, puerto);
        try {
            mcsocket.send(dgpaquete);
        } catch (Exception e) {
            System.err.println("error de envio a todos");

        }
    }

    @Override
    public void run() {
        //asigna la ip como nombre de usuario predefinido
        clientnombre = socket.getInetAddress().getHostAddress();
        String clientin;
        //usa la direccion ip dada (arbitraria en su clase, clase D) para
        //crear un grupo de escucha multicast.
        try {
            grupo = InetAddress.getByName("224.0.0.1");
        } catch (Exception e) {
            System.err.println("no existe el grupo.");

        }
        //configura el lector con buffer de entrada para el socket de recepcion
        //desde el cliente.
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (Exception e1) {
            System.err.println("error al configurar IO");
            System.exit(1);
        }
        try {
            //obtiene el nombre de usuario del cliente.
            //Si no se da, mantiene la IP como nombre usuario.
            logincliente();
            //imprime por pantalla y a los visores que el cliente se conecto.
            System.out.println(clientnombre + " conectado.");
            enviar("\n");
            enviar(clientnombre + " se ha conectado.");
            enviar("\n");
            //a continuacion recibe todo lo que escribe su cliente y lo imprime
            //a todos los visores usando el metodo enviar.
            while ((clientin = in.readLine()) != null) {
                clientin = clientnombre + ": " + clientin;
                enviar(clientin);
            }

            //la excepcion se produce al cerrar la ventana de su cliente
            //imprime por pantalla y a los visores que se desconectó y
            //muere el hilo(creo que muere automaticamente salvo que
            //algo le interrumpa, que no deberia.).
        } catch (Exception e) {

            System.err.println(clientnombre + " desconectado.");
            enviar("\n");
            enviar(clientnombre + " se ha desconectado.");
            enviar("\n");
            mcsocket.close();
        }
    }
}
