package chat;

import java.io.*;
import java.net.*;
import javax.swing.JTextArea;

public class Client implements Emoticonos {

    String host;
    int puerto;
    boolean emoticonos = true;
    JTextArea txtvisor = null;
    String clientenombre = "";
    String clientecontra = "";
    Socket clientSocket;
    PrintWriter out;
    BufferedReader stdin;

    //constructor por defecto
    public Client() {
        host = "localhost";
        puerto = 8080;
    }
    //constructor con asignacion de puerto

    public Client(int puerto) {
        host = "localhost";
        this.puerto = puerto;
    }

    public Client(String host) {
        try {
            InetAddress addr = InetAddress.getByName(host);
            this.host = addr.getHostName();
            this.puerto = 8080;
        } catch (Exception e) {
            System.err.println("Error de lectura de host.");
            this.host = "localhost";
        }
    }
    //constructor de asignacion de puerto y host, por nombre o IP.

    public Client(String host, int puerto) {
        try {
            InetAddress addr = InetAddress.getByName(host);
            this.host = addr.getHostName();
            this.puerto = puerto;
        } catch (Exception e) {
            System.err.println("Error de lectura de host.");
            this.host = "localhost";
        }
    }

    public Client(String host, int puerto, JTextArea txtvisor) {
        try {
            InetAddress addr = InetAddress.getByName(host);
            this.host = addr.getHostName();
            this.puerto = puerto;
            this.txtvisor = txtvisor;
        } catch (Exception e) {
            System.err.println("Error de lectura de host.");
            this.host = "localhost";
        }
    }
    //envia texto por socket. si es un emoticono, sustituye el texto por el emoticono ASCII.

    public void enviar(String mensaje) {
        if (mensaje != null) {
            if (emoticonos) {
                switch (mensaje) {
                    case ":)":
                        out.println(carasonriente);
                        break;
                    case ":(":
                        out.println(caratriste);
                        break;
                    case ":P":
                        out.println(caralengua);
                        break;
                    case "xD":
                        out.println(equisde);
                        break;
                    case ">:(":
                        out.println(caraenfadado);
                        break;
                    case ":O":
                        out.println(carasorpresa);
                        break;
                    default:
                        out.println(mensaje);
                }
            } else {
                out.println(mensaje);
            }

        }

    }

    //configura el socket para el envio de la entrada por teclado al servidor.
    public void configurarIO() throws IOException, UnknownHostException {
        clientSocket = new Socket(host, puerto);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        stdin = new BufferedReader(new InputStreamReader(System.in));
    }

    //abre un visor con color de fondo y letra asignado. Solo para windows.
    private void abrirvisor() {
        //comprobacion de sistema operativo windows.
        String so = System.getProperty("os.name");
        if (so.contains("Windows")) {
            try {
                System.out.println("\nColores de la pantalla y el texto DEL VISOR: " + "\n"
                        + "0: Negro" + "\t" + "1: Azul" + "\t" + "\t" + "2: Verde" + "\n"
                        + "3: Aqua" + "\t" + "\t" + "4: Rojo" + "\t" + "\t" + "5: Morado" + "\n"
                        + "6: Amarillo" + "\t" + "7: Blanco" + "\t" + "8: Gris" + "\n"
                        + "9: Azul claro" + "\t" + "A: Verde claro" + "\t" + "B: Aqua claro" + "\n"
                        + "C: Rojo claro" + "\t" + "D: Morado claro" + "\t" + "E: Amarillo claro" + "\n"
                        + "Ejemplo: 07 es pantalla negra y texto blanco." + "\n" + "\n"
                        + "Colores (Intro para colores por defecto, - para NO abrir visor): ");
                String color = stdin.readLine();
                //abre ventana visor con el color y puerto asignado, salvo que
                //el usuario no quiera (introdujo -)
                if (!color.equals("-")) {
                    Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"color " + color + " && java chat.Main -visor " + puerto + "\"");
                }


            } catch (Exception e) {
                System.err.println("error al abrir visor");
            }
        } else {
            //si no es windows, pide abrir un visor manualmente.
            System.out.println("No esta usando Windows. Abra un visor de chat con java chat.Main -visor");
        }
    }
    //permite a usuarios entrar con su nombre de usuario personal
    //enviando la contraseña al servidor para su comprobacion

    public void loginusuario() {
        try {
            //pide al usuario definir por teclado el nombre que veran los demas
            //usuarios
            System.out.println("Nombre de usuario: ");
            if (txtvisor == null) {
                clientenombre = stdin.readLine();
            }
            //envia el nombre de usuario al servidor
            out.println(clientenombre);
            // configura un lector del socket con el servidor.
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //segun lo que el servidor responda ante el nombre enviado, actua.
            //(ver Server.logincliente())
            switch (in.readLine()) {
                //caso de usuario nuevo o usuario viejo.
                case "usuariodado":
                    System.out.println(in.readLine());
                    if (txtvisor == null) {
                        clientecontra = stdin.readLine();
                    }
                    out.println(clientecontra);
                    String contrasino = in.readLine();
                    if (txtvisor != null) {
                        txtvisor.append("\n" + contrasino);
                    }
                    System.out.println(contrasino);
                    break;
                //caso de usuario no entregado al servidor.
                case "usuariovacio":
                    String usuariovacio = in.readLine();
                    System.out.println(usuariovacio);
                    if (txtvisor != null) {
                        txtvisor.append("\n" + usuariovacio);
                    }
                    break;
            }

        } catch (Exception e) {
            System.err.println("error de login");
        }
    }

    public void iniciar() {
        try {
            String input;
            //configura socket y entrada por teclado.
            configurarIO();
            //abre un visor. solo windows.
            abrirvisor();
            // muestra la configuracion al usuario.
            System.out.println("Host: " + host + "\nPuerto: " + puerto);
            // pide usuario y contraseña (si no es usuario nuevo)
            loginusuario();
            //A partir de aqui simplemente pide un mensaje por teclado y lo envia
            // al servidor.
            do {
                System.out.print("Escribir mensaje: ");
                input = stdin.readLine();
                enviar(input);
            } while (input != null);

            //El try-catch es obligatorio ya que en caso de error, el programa
            //da excepciones.
        } catch (Exception e) {
            System.err.println("error de conexion al servidor");
            System.exit(1);

        }


    }
}
