package chat;

public class Main {

    public static void main(String[] args) {

        if (args.length > 0) {

            switch (args[0]) {
                case "-server":
                    try {
                        new Multiserver(Integer.parseInt(args[1])).start();
                        
                    } catch (Exception e) {
                        new Multiserver().start();                        
                    }

                    break;
                case "-client":
                    try {
                        Client client = new Client(args[1], Integer.parseInt(args[2]));
                        client.iniciar();
                    } catch (Exception e) {

                        try {
                            Client client = new Client(Integer.parseInt(args[1]));
                            client.iniciar();
                        } catch (Exception e1) {
                            try {
                                Client client = new Client(args[1]);
                                client.iniciar();
                            } catch (Exception e2) {
                                Client client = new Client();
                                client.iniciar();
                            }
                        }
                    }
                    break;
                case "-visor":
                    try {
                        Visor visor = new Visor(Integer.parseInt(args[1]));
                        visor.start();
                    } catch (Exception e) {
                        Visor visor = new Visor();
                        visor.start();
                    }
                    break;

                case "-ayuda":
                    System.out.print("Argumentos:\n\n-server : Servidor con puerto 8080"
                            + "\n-server puerto : Servidor con puerto asignado\n"
                            + "\n-client : Cliente con host local, puerto 8080"
                            + "\n-client host : Client con host asignado, puerto 8080"
                            + "\n-client IP : Client con host asignado por direccion IP, puerto 8080"
                            + "\n-client puerto : Cliente con host local, puerto asignado"
                            + "\n-client host puerto : Cliente con host y puerto asignado"
                            + "\n-client IP puerto : Cliente con host asignado por direccion IP y puerto asignado"
                            + "\n-visor : Visor con puerto 8080"
                            + "\n-visor puerto : Visor con puerto asignado\n"
                            + "\n-ayuda : Instrucciones");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Error: Argumentos incorrectos. chat.Main -ayuda : Instrucciones");
                    System.exit(1);
                    break;
            }

        } else {
            System.err.println("Error: Argumentos incorrectos. chat.Main -ayuda : Instrucciones");
            System.exit(1);
        }

    }
}
